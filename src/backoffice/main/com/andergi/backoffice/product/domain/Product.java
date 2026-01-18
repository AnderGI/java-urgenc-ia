package com.andergi.backoffice.product.domain;

import java.util.Objects;

public final class Product {
    private final ProductId id;
    private final String name;

    public Product(final String id, final String name) {
        this.id = new ProductId(id);
        this.name = name;
    }

    public String id() {
        return id.value();
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
