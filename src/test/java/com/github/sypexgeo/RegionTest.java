package com.github.sypexgeo;

import com.github.sypexgeo.model.SxRegion;
import com.github.sypexgeo.model.SxValue;
import org.junit.Test;

import java.util.TimeZone;

/**
 *
 */
public class RegionTest extends BaseSxText {

    @Test
    public void checkLeningrad() {
        SxRegion region = queryRegion("193.111.255.236");

        assertEquals("Ленинградская область", region.name.ru());
        assertEquals("Leningradskaya Oblast'", region.name.en());
        assertEquals(47, region.getIntAttribute(SxValue.AUTO));
        assertEquals(41, region.getIntAttribute(SxValue.OKATO));
        assertEquals(1045244, region.getIntAttribute(SxValue.VK));
        assertEquals(TimeZone.getTimeZone("Europe/Moscow"), region.timeZone);
    }

    @Test
    public void checkNewYork() {
        SxRegion region = queryRegion("72.229.28.185");

        assertEquals("New York", region.getStringAttribute(SxValue.NAME_EN));
        assertEquals("Нью-Йорк", region.name.ru());
        assertEquals(TimeZone.getTimeZone("America/New_York"), region.timeZone);
        assertEquals("US-NY", region.getStringAttribute(SxValue.ISO));
        assertEquals(5060716, region.getIntAttribute(SxValue.VK));
    }
}
