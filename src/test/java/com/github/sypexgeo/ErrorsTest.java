package com.github.sypexgeo;

import org.junit.Test;

/**
 *
 */
public class ErrorsTest extends BaseSxText {

    @Test(expected = IllegalArgumentException.class)
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
}
