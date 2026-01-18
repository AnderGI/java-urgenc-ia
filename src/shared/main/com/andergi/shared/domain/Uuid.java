package com.andergi.shared.domain;

import java.util.Objects;
import java.util.UUID;

public abstract class Uuid {
    private final String value;

    public Uuid(String value) {
        this.ensureValidUuid(value);
        this.value = value;
    }

    private void ensureValidUuid(final String id) throws IllegalArgumentException{
        UUID.fromString(id);
    }

    public String value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Uuid uuid = (Uuid) o;
        return Objects.equals(value, uuid.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}


