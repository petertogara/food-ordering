package com.brilliantminds.foodordering.order.service.business.event;

import com.brilliantminds.foodordering.order.service.business.entity.Order;

import java.time.ZonedDateTime;

public class OrderCancelledEvent extends OrderEvent {
    public OrderCancelledEvent(Order order, ZonedDateTime createAt) {
        super(order, createAt);
    }
}
