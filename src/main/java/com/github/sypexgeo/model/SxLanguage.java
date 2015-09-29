package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;

/**
 *
 */
public enum SxLanguage {
    RU("ru"),
    EN("en"),
    DE("de"),
    FR("fr"),
    ES("es"),
    PT("pt");

    @NotNull
    public final String code;

    SxLanguage(@NotNull String code) {
        this.code = code;
    }
}
