package com.brilliantminds.foodordering.domain.valueobject;

import java.util.Objects;

public abstract class BaseId<T> {
    private final T value;

    protected BaseId(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof BaseId)) return false;

        BaseId<?> baseId = (BaseId<?>) o;

        return value.equals(baseId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
