package com.github.sypexgeo.model;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 *
 */
public final class SxName {

    private final Map<String, String> valuesByCode;

    public SxName(Map<String, String> valuesByCode) {
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
