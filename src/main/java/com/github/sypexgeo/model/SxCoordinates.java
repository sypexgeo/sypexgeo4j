package com.github.sypexgeo.model;

import java.util.Objects;

/**
 * Latitude and  longitude coordinates.
 */
public final class SxCoordinates {
    public final double latitude;
    public final double longitude;

    public SxCoordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SxCoordinates location = (SxCoordinates) o;
        return Double.compare(location.latitude, latitude) == 0 &&
                Double.compare(location.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}
