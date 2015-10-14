package com.github.sypexgeo;

import com.github.sypexgeo.model.SxGeoResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Cache interface for SxRestClient
 */
public interface SxCache {

    @Nullable
    List<SxGeoResult> getList(@NotNull String ips);

    void add(@NotNull String ip, @NotNull List<SxGeoResult> result);
}
