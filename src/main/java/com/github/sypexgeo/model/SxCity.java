package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 *
 */
public final class SxCity extends SxLocation {

    public SxCity(@NotNull SxId id, @NotNull SxCoordinates coordinates, @NotNull SxName name, @NotNull Map<String, SxValue> attributes) {
        super(id, coordinates, name, attributes);
    }

    // TODO: equals & hashcode

}
