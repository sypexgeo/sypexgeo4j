package com.github.sypexgeo.model.value;

/**
 *
 */
public abstract class IntValue {
    public final int value;

    public IntValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        return o == this || (o instanceof IntValue && value == ((IntValue) o).value);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + value;
    }
}
