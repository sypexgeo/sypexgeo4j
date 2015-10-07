package com.github.sypexgeo;

import com.github.sypexgeo.model.SxGeoResult;
import org.junit.Test;

/**
 *
 */
public class ErrorsTest extends BaseSxText {

    @Test(expected = NullPointerException.class)
    public void checkNullIp() {
        //noinspection ConstantConditions
        client.get(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkEmptyIp() {
        client.get("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMalformedIp1() {
        client.get("555.555.555.555");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMalformedIp2() {
        client.get("100.100.100");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMalformedIp3() {
        client.get("yandex.ru");
    }

    @Test
    public void checkNotExistingIp() {
        SxGeoResult result = client.get("127.0.0.1");
        assertNotNull(result);
        assertEquals("127.0.0.1", result.ip);
        assertNull(result.city);
        assertNull(result.region);
        assertNull(result.country);
    }
}
