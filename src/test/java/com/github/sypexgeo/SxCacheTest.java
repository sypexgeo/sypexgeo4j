package com.github.sypexgeo;

import com.github.sypexgeo.model.SxGeoResult;
import com.github.sypexgeo.util.SxMemoryCache;
import org.junit.Test;

public class SxCacheTest extends BaseSxText {
    @Test
    public void checkCache() {
        SxMemoryCache cache = new SxMemoryCache();
        assertTrue(cache.map.isEmpty());
        client.setCache(cache);

        String originalIp = "93.210.15.68";
        SxGeoResult result1 = query(originalIp);
        assertEquals(originalIp, result1.ip);
        assertNotNull(result1.city);

        assertEquals(1, cache.map.size());
        assertEquals(1, client.clientQueriesCount);
        assertEquals(1, client.restQueriesCount);

        SxGeoResult result2 = query(originalIp);
        assertEquals(originalIp, result2.ip);
        assertNotNull(result2.city);

        assertEquals(1, cache.map.size());
        assertEquals(2, client.clientQueriesCount);
        assertEquals(1, client.restQueriesCount);

        assertEquals(result1, result2);
    }
}
