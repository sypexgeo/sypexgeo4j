package com.github.sypexgeo;

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

}
