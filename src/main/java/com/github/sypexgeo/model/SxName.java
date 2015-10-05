package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Entry name for SxCity, SxRegion or SxCountry. Response can contains name in multiple languages.
 * All responses contain Russian and English name variants that are supported by helper methods.
 */
public final class SxName {

    @NotNull
    private final Map<String, String> valuesByCode;

    public SxName(@NotNull Map<String, String> valuesByCode) {
        this.valuesByCode = valuesByCode;
    }

    @Nullable
    public String getRu() {
        return get(SxLanguage.RU);
    }

    @Nullable
    public String getEn() {
        return get(SxLanguage.EN);
    }

    @Nullable
    public String get(SxLanguage l) {
        return valuesByCode.get(l.code);
    }

    @Nullable
    public String get(String languageCode) {
        return valuesByCode.get(languageCode);
    }

    //todo: equals & hashcode
}
