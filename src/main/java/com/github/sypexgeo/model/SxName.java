package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Objects;

/**
 * Entry name for SxCity, SxRegion or SxCountry in multiple languages.
 */
public final class SxName {

    @NotNull
    private final Map<String, String> valuesByCode;

    public SxName(@NotNull Map<String, String> valuesByCode) {
        this.valuesByCode = valuesByCode;
    }

    @NotNull
    public String ru() {
        return Objects.requireNonNull(get(SxLanguage.RU));
    }

    @NotNull
    public String en() {
        return Objects.requireNonNull(get(SxLanguage.EN));
    }

    @NotNull
    public String de() {
        return Objects.requireNonNull(get(SxLanguage.DE));
    }

    @NotNull
    public String fr() {
        return Objects.requireNonNull(get(SxLanguage.FR));
    }

    @NotNull
    public String es() {
        return Objects.requireNonNull(get(SxLanguage.ES));
    }

    @NotNull
    public String pt() {
        return Objects.requireNonNull(get(SxLanguage.PT));
    }

    @Nullable
    public String get(SxLanguage l) {
        return valuesByCode.get(l.code);
    }

    @Nullable
    public String get(String languageCode) {
        return valuesByCode.get(languageCode);
    }

    @Override
    public boolean equals(Object o) {
        return this == o || !(o == null || getClass() != o.getClass()) && Objects.equals(valuesByCode, ((SxName) o).valuesByCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valuesByCode);
    }
}
