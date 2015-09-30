package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.TimeZone;

/**
 *
 */
public final class SxCountry extends SxLocation {
    @NotNull
    public final SxISO iso;

    @NotNull
    public final SxContinent continent;

    @Nullable
    public final TimeZone timeZone;

    public SxCountry(@NotNull SxId id, @NotNull SxCoordinates coordinates, @NotNull SxName name, @Nullable SxVkId vkId,
                     @NotNull SxISO iso, @NotNull SxContinent continent, @Nullable TimeZone timeZone) {
        super(id, coordinates, name, vkId);
        this.iso = iso;
        this.continent = continent;
        this.timeZone = timeZone;
    }
    // TODO: equals & hashcode
}
