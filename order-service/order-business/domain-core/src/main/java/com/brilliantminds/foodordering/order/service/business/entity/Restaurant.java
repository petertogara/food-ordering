package com.brilliantminds.foodordering.order.service.business.entity;

import com.brilliantminds.foodordering.domain.entity.AggregateRoot;
import com.brilliantminds.foodordering.domain.valueobject.RestaurantId;

import java.util.List;

public class Restaurant extends AggregateRoot<RestaurantId> {
    private final List<Product> products;
    private boolean active;

    public Restaurant(Builder builder) {
        super.setId(builder.restaurantId);
        this.products = builder.products;
        this.active = builder.active;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean isActive() {
        return active;
    }

    public static class Builder {
        private RestaurantId restaurantId;
        private List<Product> products;
        private boolean active;

        public Builder() {

        }

        public Builder restaurantId(RestaurantId val) {
            restaurantId = val;
            return this;
        }

        public Builder products(List<Product> val) {
            products = val;
            return this;
        }

        public Builder active(boolean val) {
            active = val;
            return this;
        }

        public Restaurant build() {
            return new Restaurant(this);
        }
    }
}
