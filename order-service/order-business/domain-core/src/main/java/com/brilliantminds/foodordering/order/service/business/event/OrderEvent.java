package com.brilliantminds.foodordering.order.service.business.event;

import com.brilliantminds.foodordering.domain.event.DomainEvent;
import com.brilliantminds.foodordering.order.service.business.entity.Order;

import java.time.ZonedDateTime;

public class OrderEvent implements DomainEvent<Order> {
    private final Order order;
    private final ZonedDateTime createAt;

    public OrderEvent(Order order, ZonedDateTime createAt) {
        this.order = order;
        this.createAt = createAt;
    }

    public Order getOrder() {
        return order;
    }

    public ZonedDateTime getCreateAt() {
        return createAt;
    }
}