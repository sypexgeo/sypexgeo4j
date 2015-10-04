package com.github.sypexgeo.model.value;

/**
 * 'Int' value objects. Wraps non-nullable string value & implements hashCode(), equals() & toString methods.
 */
public abstract class IntValue {

    /**
     * The value wrapped by class.
     */
    public final int value;

    /**
     * Initializes new IntValue object.
     *
     * @param value - any 'int' value.
     */
    public IntValue(int value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        return o == this || (o instanceof IntValue && value == ((IntValue) o).value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + value;
    }
}
