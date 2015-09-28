package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;

/**
 *
 */
public class SxName {
    @NotNull
    public final String enName;
    @NotNull
    public final String ruName;

    public SxName(@NotNull String ruName, @NotNull String enName) {
        this.ruName = ruName;
        this.enName = enName;
    }
}
