package com.github.sypexgeo;

import com.github.sypexgeo.model.SxCity;
import com.github.sypexgeo.model.SxContinent;
import com.github.sypexgeo.model.SxCountry;
import com.github.sypexgeo.model.SxGeoResult;
import com.github.sypexgeo.model.SxISO;
import com.github.sypexgeo.model.SxId;
import com.github.sypexgeo.model.SxLocation;
import com.github.sypexgeo.model.SxName;
import com.github.sypexgeo.model.SxOkato;
import com.github.sypexgeo.model.SxRegion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Pattern;

/**
 *
 */
public class SxRestClient {

    private static final Pattern IPV4_PATTERN = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    protected SxRestClient() {
    }

    @NotNull
    public static SxRestClient create() {
        return new SxRestClient();
    }

    @NotNull
    public List<SxGeoResult> get(@NotNull String ip) {
        if (!IPV4_PATTERN.matcher(ip).matches()) {
            throw new IllegalArgumentException("Illegal IP address: " + ip);
        }
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse("http://api.sypexgeo.net/xml/" + ip);
            NodeList ipNodes = doc.getElementsByTagName("ip");
            List<SxGeoResult> result = new ArrayList<>();
            for (int i = 0; i < ipNodes.getLength(); i++) {
                result.add(parseIp((Element) ipNodes.item(i)));
            }
            return result;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static SxGeoResult parseIp(Element ipNode) {
        String ip = ipNode.getAttribute("num");

        NodeList cityNodes = ipNode.getElementsByTagName("city");
        SxCity city = cityNodes.getLength() == 0 ? null : parseCity((Element) cityNodes.item(0));

        NodeList regionNodes = ipNode.getElementsByTagName("region");
        SxRegion region = regionNodes.getLength() == 0 ? null : parseRegion((Element) regionNodes.item(0));

        NodeList countryNodes = ipNode.getElementsByTagName("country");
        SxCountry country = countryNodes.getLength() == 0 ? null : parseCountry((Element) cityNodes.item(0));

        return new SxGeoResult(ip, city, region, country);
    }

    private static SxCity parseCity(Element city) {
        return new SxCity(parseId(city), parseLocation(city), parseName(city), parseOkato(city));
    }

    private static SxRegion parseRegion(Element region) {
        return new SxRegion(parseId(region), parseLocation(region), parseName(region), parseISO(region), parseTimeZone(region), parseOkato(region));
    }

    private static SxCountry parseCountry(Element country) {
        return new SxCountry(parseId(country), parseISO(country), parseContinent(country), parseLocation(country), parseName(country), parseTimeZone(country));
    }


    @NotNull
    private static String parseRequiredValue(Element e, String tag) {
        return e.getElementsByTagName(tag).item(0).getTextContent();
    }

    @Nullable
    private static String parseValue(Element e, String tag) {
        NodeList nodeList = e.getElementsByTagName(tag);
        return nodeList.getLength() > 0 ? nodeList.item(0).getTextContent() : null;
    }

    @NotNull
    private static SxId parseId(Element e) {
        return new SxId(Integer.parseInt(parseRequiredValue(e, "id")));
    }

    @NotNull
    private static SxLocation parseLocation(Element e) {
        String lat = parseRequiredValue(e, "lat");
        String lon = parseRequiredValue(e, "lon");
        return new SxLocation(Double.parseDouble(lat), Double.parseDouble(lon));
    }

    @NotNull
    private static SxName parseName(Element e) {
        String enName = parseRequiredValue(e, "name_en");
        String ruName = parseRequiredValue(e, "name_ru");
        return new SxName(ruName, enName);
    }

    @NotNull
    private static SxOkato parseOkato(Element e) {
        String okato = parseRequiredValue(e, "okato");
        return new SxOkato(okato);
    }

    @NotNull
    private static SxISO parseISO(Element e) {
        String iso = parseValue(e, "iso");
        return new SxISO(iso);
    }

    @NotNull
    private static TimeZone parseTimeZone(Element e) {
        String timezoneId = parseValue(e, "timezone");
        return timezoneId != null ? TimeZone.getTimeZone(timezoneId) : null;
    }

    @NotNull
    private static SxContinent parseContinent(Element e) {
        String continent = parseValue(e, "continent");
        return SxContinent.fromCode(continent);
    }


}
