package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;

/**
 * Convenience class to list the most frequent languages found in sypex responses.
 */
public enum SxLanguage {
    /**
     * Russian.
     */
    RU("ru"),
    /**
     * English.
     */
    EN("en"),
    /**
     * German.
     */
    DE("de"),
    /**
     * French.
     */
    FR("fr"),
    /**
     * Spanish.
     */
    ES("es"),
    /**
     * Portuguese.
     */
    PT("pt");

    @NotNull
    public final String code;

    SxLanguage(@NotNull String code) {
        this.code = code;
    }
}
