package com.github.sypexgeo;

import com.github.sypexgeo.model.SxCity;
import com.github.sypexgeo.model.SxValue;
import org.junit.Test;

/**
 *
 */
public class CityTest extends BaseSxText {

    @Test
    public void checkNsk() {
        SxCity city = queryCity("93.92.217.228");

        assertEquals("Novosibirsk", city.name.en());
        assertEquals("Новосибирск", city.name.ru());
        assertEquals("Новосибирск", city.getStringAttribute(SxValue.NAME_RU));
    }

    @Test
    public void checkSeattle() {
        SxCity city = queryCity("174.21.165.19");

        assertEquals("Seattle", city.getStringAttribute(SxValue.NAME_EN));
        assertEquals("Сиэтл", city.name.ru());
    }

    @Test
    public void checkMoscow() {
        SxCity city = queryCity("79.164.156.24");
        assertEquals("Moscow", city.getStringAttribute(SxValue.NAME_EN));
        assertEquals("Москва", city.name.ru());
        assertEquals(45, city.getIntAttribute(SxValue.OKATO));
        assertEquals(1, city.getIntAttribute(SxValue.VK));
        assertTrue(city.getIntAttribute(SxValue.POPULATION) > 10 * 1000 * 1000);
    }

}
