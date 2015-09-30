package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 *
 */
public final class SxGeoResult {
    @NotNull
    public final String ip;

    @Nullable
    public final SxCity city;

    @Nullable
    public final SxRegion region;

    @Nullable
    public final SxCountry country;

    public SxGeoResult(@NotNull String ip, @Nullable SxCity city, @Nullable SxRegion region, @Nullable SxCountry country) {
        Objects.requireNonNull(ip);

        this.ip = ip;
        this.city = city;
        this.region = region;
        this.country = country;
    }

    // TODO: equals & hashcode
}
