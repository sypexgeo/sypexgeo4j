package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.TimeZone;

/**
 *
 */
public final class SxRegion extends SxLocation {


    //todo: move to SxLocation
    @Nullable
    public final TimeZone timeZone;

    public SxRegion(@NotNull SxId id, @NotNull SxCoordinates coordinates, @NotNull SxName name, @Nullable TimeZone timeZone, Map<String, SxValue> attributes) {
        super(id, coordinates, name, attributes);
        this.timeZone = timeZone;
    }

    //todo: equals & hashcode
}
