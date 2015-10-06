package com.github.sypexgeo;

import com.github.sypexgeo.model.SxCity;
import com.github.sypexgeo.model.SxCountry;
import com.github.sypexgeo.model.SxGeoResult;
import com.github.sypexgeo.model.SxRegion;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Before;

import java.util.List;

/**
 *
 */
public class BaseSxText extends Assert {
    protected SxRestClient client;

    @Before
    public void setUp() {
        client = SxRestClient.create();
    }

    @NotNull
    protected SxGeoResult query(@NotNull String ip) {
        List<SxGeoResult> result = client.getList(ip);
        assertNotNull(result);
        assertEquals(1, result.size());

        SxGeoResult res = result.get(0);
        assertNotNull(res.city);
        assertNotNull(res.region);
        assertNotNull(res.country);

        return res;
    }

    @NotNull
    protected SxCity queryCity(@NotNull String ip) {
        SxGeoResult res = query(ip);
        assertNotNull(res.city);
        return res.city;
    }

    @NotNull
    protected SxRegion queryRegion(@NotNull String ip) {
        SxGeoResult res = query(ip);
        assertNotNull(res.region);
        return res.region;
    }

    @NotNull
    protected SxCountry queryCountry(@NotNull String ip) {
        SxGeoResult res = query(ip);
        assertNotNull(res.country);
        return res.country;
    }

}
