package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.TimeZone;

/**
 *
 */
public final class SxCity extends SxLocation {

    public SxCity(@NotNull SxId id, @NotNull SxCoordinates coordinates, @NotNull SxName name, @Nullable TimeZone timeZone, @NotNull Map<String, SxValue> attributes) {
        super(id, coordinates, name, timeZone, attributes);
    }

    // TODO: equals & hashcode
}
