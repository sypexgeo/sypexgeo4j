package com.github.sypexgeo.model.value;

import org.jetbrains.annotations.NotNull;

/**
 *
 */
public abstract class StringValue {
    @NotNull
    public final String value;

    public StringValue(@NotNull String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        return o == this || (o instanceof StringValue && value.equals(((StringValue) o).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
