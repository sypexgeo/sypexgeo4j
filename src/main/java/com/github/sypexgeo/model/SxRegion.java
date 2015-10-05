package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.TimeZone;

/**
 * Region record in Sypex response.
 */
public final class SxRegion extends SxLocation {

    public SxRegion(@NotNull SxId id, @NotNull SxCoordinates coordinates, @NotNull SxName name, @Nullable TimeZone timeZone, Map<String, SxValue> attributes) {
        super(id, coordinates, name, timeZone, attributes);
    }
}
