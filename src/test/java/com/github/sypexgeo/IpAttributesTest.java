package com.github.sypexgeo;

import com.github.sypexgeo.model.SxGeoResult;
import org.junit.Test;

public class IpAttributesTest extends BaseSxText {
    @Test
    public void checkIp() {
        SxGeoResult result = query("131.228.17.26");
        assertEquals("131.228.17.26", result.ip);
        assertFalse(result.ipAttributes.isEmpty());
        assertTrue(result.ipAttributes.containsKey("created"));
        assertTrue(result.ipAttributes.containsKey("error"));
        assertTrue(result.ipAttributes.containsKey("timestamp"));
    }
}
