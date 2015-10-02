package com.github.sypexgeo;

import com.github.sypexgeo.model.SxGeoResult;
import com.github.sypexgeo.model.SxValue;
import org.junit.Test;

import java.util.List;

/**
 *
 */
public class RussianCitiesTest extends BaseSxText {

    @Test
    public void checkCity1() {
        List<SxGeoResult> result = client.get("93.92.217.228");
        assertNotNull(result);
        assertTrue(!result.isEmpty());

        SxGeoResult res = result.get(0);
        assertNotNull(res.city);

        assertEquals("Novosibirsk", res.city.name.getEn());
        assertEquals("Новосибирск", res.city.name.getRu());
    }


    @Test
    public void checkAttributes() {
        List<SxGeoResult> result = client.get("174.21.165.19");
        assertNotNull(result);
        assertTrue(!result.isEmpty());

        SxGeoResult res = result.get(0);
        assertNotNull(res.city);

        assertEquals("Seattle", res.city.getStringAttribute(SxValue.NAME_EN));
    }
}
