package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 *
 */
public final class SxCity extends SxLocation {
    @NotNull
    public final SxOkato okato;

    public SxCity(@NotNull SxId id, @NotNull SxCoordinates coordinates, @NotNull SxName name, @Nullable SxVkId vkId, @NotNull SxOkato okato) {
        super(id, coordinates, name, vkId);
        this.okato = okato;
    }

    // TODO: equals & hashcode

}
