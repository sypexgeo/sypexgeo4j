package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 *
 */
public abstract class SxLocation {
    @NotNull
    public final SxId id;

    @NotNull
    public final SxCoordinates coordinates;

    @NotNull
    public final SxName name;

    @Nullable
    public final SxVkId vkId;

    public SxLocation(@NotNull SxId id, @NotNull SxCoordinates coordinates, @NotNull SxName name, @Nullable SxVkId vkId) {
        this.id = id;
        this.coordinates = coordinates;
        this.name = name;
        this.vkId = vkId;
    }

    // TODO: equals & hashcode
}
