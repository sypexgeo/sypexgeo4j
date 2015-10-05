package com.github.sypexgeo.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Map;
import java.util.TimeZone;

/**
 * Base class for SxCity, SxRegion and SxCountry. Holds id, coordinates and name.
 */
public abstract class SxLocation {
    @NotNull
    public final SxId id;

    @NotNull
    public final SxCoordinates coordinates;

    @NotNull
    public final SxName name;

    @Nullable
    public final TimeZone timeZone;

    /**
     * Complete list of attributes: both parsed & unparsed. Unmodifiable map.
     */
    @NotNull
    public final Map<String, SxValue> attributes;

    public SxLocation(@NotNull SxId id, @NotNull SxCoordinates coordinates, @NotNull SxName name, @Nullable TimeZone timeZone, @NotNull Map<String, SxValue> attributes) {
        this.id = id;
        this.coordinates = coordinates;
        this.name = name;
        this.timeZone = timeZone;
        this.attributes = Collections.unmodifiableMap(attributes);
    }

    @Nullable
    public SxValue getAttribute(@Nullable String name) {
        return name == null || name.isEmpty() ? null : attributes.get(name);
    }

    @Nullable
    public String getStringAttribute(@Nullable String name) {
        SxValue value = getAttribute(name);
        return value == null ? null : value.value;
    }

    public int getIntAttribute(@Nullable String name, int defaultValue) {
        SxValue value = getAttribute(name);
        try {
            return value == null ? defaultValue : Integer.parseInt(value.value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    // TODO: equals & hashcode
}
