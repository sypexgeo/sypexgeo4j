package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;

import java.util.TimeZone;

/**
 *
 */
public class SxRegion {
    @NotNull
    public final SxId id;

    @NotNull
    public final SxLocation location;

    @NotNull
    public final SxName name;

    @NotNull
    public final SxISO iso;

    @NotNull
    public final TimeZone timeZone;

    @NotNull
    public final SxOkato okato;

    public SxRegion(@NotNull SxId id, @NotNull SxLocation location, @NotNull SxName name, @NotNull SxISO iso, @NotNull TimeZone timeZone, @NotNull SxOkato okato) {
        this.id = id;
        this.location = location;
        this.name = name;
        this.iso = iso;
        this.timeZone = timeZone;
        this.okato = okato;
    }
}
