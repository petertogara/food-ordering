package com.brilliantminds.foodordering.domain.valueobject;

import java.util.UUID;

public class RestaurantId extends BaseId<UUID>{
    protected RestaurantId(UUID value) {
        super(value);
    }
}
