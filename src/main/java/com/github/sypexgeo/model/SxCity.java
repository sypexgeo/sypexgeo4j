package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;

/**
 *
 */
public class SxCity {
    @NotNull
    public final SxId id;

    @NotNull
    public final SxLocation location;

    @NotNull
    public final SxName name;

    @NotNull
    public final SxOkato okato;

    public SxCity(@NotNull SxId id, @NotNull SxLocation location, @NotNull SxName name, @NotNull SxOkato okato) {
        this.id = id;
        this.location = location;
        this.name = name;
        this.okato = okato;
    }
}
