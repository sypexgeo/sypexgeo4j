package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

/**
 *
 */
public enum SxContinent {
    AS("AS");

    @NotNull
    public final String code;

    SxContinent(@NotNull String code) {

        this.code = code;
    }

    @Nullable
    public static SxContinent fromCode(@NotNull String code) {
        return Arrays.stream(values()).filter(c -> c.code.equals(code)).findAny().orElse(null);
    }
}
