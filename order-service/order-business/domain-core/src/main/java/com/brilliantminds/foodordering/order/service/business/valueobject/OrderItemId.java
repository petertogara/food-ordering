package com.brilliantminds.foodordering.order.service.business.valueobject;

import com.brilliantminds.foodordering.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
