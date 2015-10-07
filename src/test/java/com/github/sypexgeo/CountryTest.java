package com.github.sypexgeo;

import com.github.sypexgeo.model.SxCountry;
import com.github.sypexgeo.model.SxValue;
import org.junit.Test;

import java.util.TimeZone;

/**
 *
 */
public class CountryTest extends BaseSxText {

    @Test
    public void checkFrance() {
        SxCountry country = queryCountry("88.190.229.170");

        assertEquals("Франция", country.name.ru());
        assertEquals("France", country.name.en());
        assertEquals(547030, country.getIntAttribute(SxValue.AREA));
        assertEquals(2988507, country.getIntAttribute(SxValue.CAPITAL_ID));
        assertEquals("Paris", country.getStringAttribute(SxValue.CAPITAL_EN));
        assertEquals("EUR", country.getStringAttribute(SxValue.CUR_CODE));
        assertEquals(33, country.getIntAttribute(SxValue.PHONE));
        assertEquals("CH,DE,BE,LU,IT,AD,MC,ES", country.getStringAttribute(SxValue.NEIGHBOURS));
        assertEquals(209, country.getIntAttribute(SxValue.VK));
        assertEquals(TimeZone.getTimeZone("Europe/Paris"), country.timeZone);
    }

    @Test
    public void checkUzbekistan() {
        SxCountry country = queryCountry("77.220.192.0");

        assertEquals("Узбекистан", country.name.ru());
        assertEquals("Usbekistan", country.name.de());
        assertEquals(447400, country.getIntAttribute(SxValue.AREA));
        assertEquals(1512569, country.getIntAttribute(SxValue.CAPITAL_ID));
        assertEquals("Tashkent", country.getStringAttribute(SxValue.CAPITAL_EN));
        assertEquals("UZS", country.getStringAttribute(SxValue.CUR_CODE));
        assertEquals(998, country.getIntAttribute(SxValue.PHONE));
        assertEquals("TM,AF,KG,TJ,KZ", country.getStringAttribute(SxValue.NEIGHBOURS));
        assertEquals(18, country.getIntAttribute(SxValue.VK));
        assertEquals(TimeZone.getTimeZone("Asia/Tashkent"), country.timeZone);
    }

    @Test
    public void checkRussia() {
        SxCountry country = queryCountry("195.209.84.0");

        assertEquals("Россия", country.name.ru());
        assertEquals("Rússia", country.name.pt());
        assertEquals(17100000, country.getIntAttribute(SxValue.AREA));
        assertEquals(524901, country.getIntAttribute(SxValue.CAPITAL_ID));
        assertEquals("Москва", country.getStringAttribute(SxValue.CAPITAL_RU));
        assertEquals("RUB", country.getStringAttribute(SxValue.CUR_CODE));
        assertEquals(7, country.getIntAttribute(SxValue.PHONE));
        assertEquals("GE,CN,BY,UA,KZ,LV,PL,EE,LT,FI,MN,NO,AZ,KP", country.getStringAttribute(SxValue.NEIGHBOURS));
        assertEquals(1, country.getIntAttribute(SxValue.VK));
        assertEquals(TimeZone.getTimeZone("Europe/Moscow"), country.timeZone);
    }
}
