package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.TimeZone;

/**
 *
 */
public final class SxRegion extends SxLocation {
    @Nullable
    public final SxISO iso;

    @Nullable
    public final TimeZone timeZone;

    @NotNull
    public final SxOkato okato;

    public SxRegion(@NotNull SxId id, @NotNull SxCoordinates coordinates, @NotNull SxName name, @Nullable SxVkId vkId,
                    @Nullable SxISO iso, @Nullable TimeZone timeZone, @NotNull SxOkato okato) {
        super(id, coordinates, name, vkId);
        this.iso = iso;
        this.timeZone = timeZone;
        this.okato = okato;
    }

    //todo: equals & hashcode
}
