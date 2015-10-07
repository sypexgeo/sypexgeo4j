package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * Sypex query result: contains city, region and country info.
 */
public final class SxGeoResult {
    // TODO: add header params! Rework Ip to SxIP

    @NotNull
    public final String ip;

    @NotNull
    public final Map<String, String> ipAttributes;

    @Nullable
    public final SxCity city;

    @Nullable
    public final SxRegion region;

    @Nullable
    public final SxCountry country;

    public SxGeoResult(@NotNull Map<String, String> ipAttributes, @Nullable SxCity city, @Nullable SxRegion region, @Nullable SxCountry country) {
        this.ipAttributes = Collections.unmodifiableMap(ipAttributes);
        ip = Objects.requireNonNull(ipAttributes.get("num"));
        this.city = city;
        this.region = region;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SxGeoResult result = (SxGeoResult) o;
        return Objects.equals(ip, result.ip) &&
                Objects.equals(city, result.city) &&
                Objects.equals(region, result.region) &&
                Objects.equals(country, result.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, city, region, country);
    }
}
