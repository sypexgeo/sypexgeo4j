package com.github.sypexgeo;

import org.junit.Assert;
import org.junit.Before;

/**
 *
 */
public class BaseSxText extends Assert{
    protected SxRestClient client;

    @Before
    public void setUp() {
        client = SxRestClient.create();
    }

}
