package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.TimeZone;

/**
 * Country record in Sypex response.
 */
public final class SxCountry extends SxLocation {

    public SxCountry(@NotNull SxId id, @NotNull SxCoordinates coordinates, @NotNull SxName name, @Nullable TimeZone timeZone, Map<String, SxValue> attributes) {
        super(id, coordinates, name, timeZone, attributes);
    }

}
