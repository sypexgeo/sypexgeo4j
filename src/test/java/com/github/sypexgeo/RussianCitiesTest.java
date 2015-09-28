package com.github.sypexgeo;

import com.github.sypexgeo.model.SxGeoResult;
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

        assertEquals("Novosibirsk", res.city.name.enName);
        assertEquals("Новосибирск", res.city.name.ruName);
    }
}
