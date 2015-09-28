package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;

import java.util.TimeZone;

/**
 *
 */
public class SxCountry {
    @NotNull
    public final SxId id;

    @NotNull
    public final SxISO iso;

    @NotNull
    public final SxContinent continent;

    @NotNull
    public final SxLocation location;

    @NotNull
    public final SxName name;

    @NotNull
    public final TimeZone timeZone;

    public SxCountry(@NotNull SxId id, @NotNull SxISO iso, @NotNull SxContinent continent, @NotNull SxLocation location, @NotNull SxName name, @NotNull TimeZone timeZone) {
        this.id = id;
        this.iso = iso;
        this.continent = continent;
        this.location = location;
        this.name = name;
        this.timeZone = timeZone;
    }
}
