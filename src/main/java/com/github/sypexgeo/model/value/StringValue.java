package com.github.sypexgeo.model.value;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * String value objects. Wraps non-nullable string value & implements hashCode(), equals() & toString methods.
 */
public abstract class StringValue {
    /**
     * The value wrapped by class.
     */
    @NotNull
    public final String value;

    /**
     * Initializes new StringValue object.
     *
     * @param value - non nul string value.
     * @throws NullPointerException if provided String value is null.
     */
    public StringValue(@NotNull String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        return o == this || (o instanceof StringValue && value.equals(((StringValue) o).value));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + value;
    }
}
