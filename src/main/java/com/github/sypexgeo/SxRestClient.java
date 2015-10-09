package com.github.sypexgeo;

import com.github.sypexgeo.model.SxCity;
import com.github.sypexgeo.model.SxCoordinates;
import com.github.sypexgeo.model.SxCountry;
import com.github.sypexgeo.model.SxGeoResult;
import com.github.sypexgeo.model.SxId;
import com.github.sypexgeo.model.SxName;
import com.github.sypexgeo.model.SxRegion;
import com.github.sypexgeo.model.SxValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;


/**
 * Main class of the package: executes requests for Sypex server.
 */
public class SxRestClient {

    private static final Pattern IPV4_PATTERN = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    private static final Pattern IPV4_COMMA_SEPARATED_PATTERN =
            Pattern.compile("((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)(,\\n|,?$))");

    @Nullable
    private final String key;

    @Nullable
    protected SxCache cache;

    protected int clientQueriesCount;

    protected int restQueriesCount;

    protected SxRestClient(@Nullable String key) {
        this.key = key;
    }

    /**
     * Creates new SxRestClient initialized with unique customer key.
     * If customer key is null - anonymous queries are used (<=10k per month are allowed).
     */
    @NotNull
    public static SxRestClient create(@Nullable String key) {
        return new SxRestClient(key);
    }

    /**
     * Executes REST request and return results for a given IPs.
     * Normally there is only 1 result in the list per IP.
     *
     * @param ip IP to get geo info for. Multiple IPs can be used with comma as separator.
     * @return list of SxGeoResult results
     * @throws IllegalArgumentException if IP address is invalid.
     */
    @NotNull
    public List<SxGeoResult> getList(@NotNull String ip) {
        if (!IPV4_COMMA_SEPARATED_PATTERN.matcher(ip).matches()) {
            throw new IllegalArgumentException("Illegal IP address or list: " + ip);
        }
        clientQueriesCount++;
        List<SxGeoResult> cachedResult = cache == null ? null : cache.getList(ip);
        if (cachedResult != null) {
            return cachedResult;
        }
        try {
            NodeList ipNodes = query(ip);
            ArrayList<SxGeoResult> result = new ArrayList<>();
            for (int i = 0; i < ipNodes.getLength(); i++) {
                result.add(parseIp((Element) ipNodes.item(i)));
            }
            if (cache != null) {
                cache.add(ip, result);
            }
            return result;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Executes REST request for a single IP address.
     */
    @Nullable
    public SxGeoResult get(@NotNull String ip) {
        if (!IPV4_PATTERN.matcher(ip).matches()) {
            throw new IllegalArgumentException("Illegal IP address: " + ip);
        }
        clientQueriesCount++;
        List<SxGeoResult> cachedResult = cache == null ? null : cache.getList(ip);
        if (cachedResult != null) {
            return cachedResult.isEmpty() ? null : cachedResult.get(0);
        }
        try {
            NodeList ipNodes = query(ip);
            SxGeoResult result = ipNodes.getLength() == 0 ? null : parseIp((Element) ipNodes.item(0));
            if (cache != null) {
                cache.add(ip, Collections.singletonList(result));
            }
            return result;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Sets cache to be used before making any network call or null if no cache is needed.
     * By default no cache is used.
     *
     * @param cache to be used before calling remote service. If null -> uses default mode without caching.
     */
    public void setCache(@Nullable SxCache cache) {
        this.cache = cache;
    }

    private NodeList query(@NotNull String ip) throws ParserConfigurationException, SAXException, IOException {
        restQueriesCount++;
        URL url = new URL("http://api.sypexgeo.net/" + (key == null ? "" : key + "/") + "xml/" + ip);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");
        connection.setRequestProperty("User-Agent", "SypexGeo4J Java client, https://github.com/sypexgeo/sypexgeo4j");
        try (InputStream is = connection.getInputStream()) {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            return doc.getElementsByTagName("ip");
        }
    }

    private static SxGeoResult parseIp(Element ipNode) {
        NodeList cityNodes = ipNode.getElementsByTagName("city");
        SxCity city = cityNodes.getLength() == 0 ? null : parseCity((Element) cityNodes.item(0));

        NodeList regionNodes = ipNode.getElementsByTagName("region");
        SxRegion region = regionNodes.getLength() == 0 ? null : parseRegion((Element) regionNodes.item(0));

        NodeList countryNodes = ipNode.getElementsByTagName("country");
        SxCountry country = countryNodes.getLength() == 0 ? null : parseCountry((Element) countryNodes.item(0));

        Map<String, String> ipAttributes = new HashMap<>();
        NamedNodeMap attributesMap = ipNode.getAttributes();
        for (int i = 0; i < attributesMap.getLength(); i++) {
            Node attribute = attributesMap.item(i);
            ipAttributes.put(attribute.getNodeName(), attribute.getNodeValue());
        }
        return new SxGeoResult(ipAttributes, city, region, country);
    }

    @Nullable
    private static SxCity parseCity(@NotNull Element city) {
        SxId id = getId(city);
        return id == null ? null : new SxCity(id, getCoordinates(city), getName(city), getTimeZone(city), getAttributes(city));
    }

    @Nullable
    private static SxRegion parseRegion(@NotNull Element region) {
        SxId id = getId(region);
        return id == null ? null : new SxRegion(id, getCoordinates(region), getName(region), getTimeZone(region), getAttributes(region));
    }

    @Nullable
    private static SxCountry parseCountry(Element country) {
        SxId id = getId(country);
        return id == null ? null : new SxCountry(id, getCoordinates(country), getName(country), getTimeZone(country), getAttributes(country));
    }

    @NotNull
    private static String getRequiredValue(Element e, String tag) {
        return e.getElementsByTagName(tag).item(0).getTextContent();
    }

    @Nullable
    private static String getValue(Element e, String tag) {
        NodeList nodeList = e.getElementsByTagName(tag);
        return nodeList.getLength() > 0 ? nodeList.item(0).getTextContent() : null;
    }

    @Nullable
    private static SxId getId(Element e) {
        String value = getValue(e, SxValue.ID);
        return value == null || value.isEmpty() ? null : new SxId(Integer.parseInt(value));
    }

    @NotNull
    private static SxCoordinates getCoordinates(Element e) {
        String lat = getRequiredValue(e, SxValue.LAT);
        String lon = getRequiredValue(e, SxValue.LON);
        return new SxCoordinates(Double.parseDouble(lat), Double.parseDouble(lon));
    }

    @NotNull
    private static SxName getName(Element e) {
        Map<String, String> valuesByCode = new HashMap<>();
        for (Element el : getChildrenByPrefix(e, "name_")) {
            String code = el.getTagName().substring(5);
            String val = el.getTextContent();
            valuesByCode.put(code, val);
        }
        return new SxName(valuesByCode);
    }

    @Nullable
    private static TimeZone getTimeZone(Element e) {
        String timezoneId = getValue(e, SxValue.TIMEZONE);
        return timezoneId != null ? TimeZone.getTimeZone(timezoneId) : null;
    }

    @NotNull
    private static List<Element> getChildrenByPrefix(@NotNull Element e, @NotNull String prefix) {
        List<Element> res = new ArrayList<>();
        NodeList nodes = e.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element && ((Element) node).getTagName().startsWith(prefix)) {
                res.add((Element) node);
            }
        }
        return res;
    }

    @NotNull
    private static Map<String, SxValue> getAttributes(Element element) {
        Map<String, SxValue> result = new HashMap<>();
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node instanceof Element) {
                Element e = (Element) node;
                result.put(e.getTagName(), new SxValue(e.getTextContent()));
            }
        }
        return result;
    }
}
