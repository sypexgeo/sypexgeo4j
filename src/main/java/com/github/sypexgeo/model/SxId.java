package com.github.sypexgeo.model;

import com.github.sypexgeo.model.value.IntValue;

/**
 * Id for entries in response. Referenced by SxValue.ID for SxLocation (SxCity, SxRegion, SxCountry)
 */
public final class SxId extends IntValue {

    public SxId(int value) {
        super(value);
    }
}
