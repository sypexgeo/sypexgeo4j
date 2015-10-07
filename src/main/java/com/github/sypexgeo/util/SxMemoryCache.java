package com.github.sypexgeo.util;

import com.github.sypexgeo.SxCache;
import com.github.sypexgeo.model.SxGeoResult;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class SxMemoryCache implements SxCache {

    public final Map<String, List<SxGeoResult>> map = new ConcurrentHashMap<>();

    @NotNull
    @Override
    public List<SxGeoResult> getList(@NotNull String ips) {
        return map.get(ips);
    }

    @Override
    public void add(@NotNull String ip, @NotNull List<SxGeoResult> result) {
        map.put(ip, result);
    }
}
