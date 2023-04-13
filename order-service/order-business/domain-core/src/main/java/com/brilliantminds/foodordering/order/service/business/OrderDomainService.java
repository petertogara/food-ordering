package com.brilliantminds.foodordering.order.service.business;

import com.brilliantminds.foodordering.order.service.business.entity.Order;
import com.brilliantminds.foodordering.order.service.business.entity.Restaurant;
import com.brilliantminds.foodordering.order.service.business.event.OrderCancelledEvent;
import com.brilliantminds.foodordering.order.service.business.event.OrderCreatedEvent;
import com.brilliantminds.foodordering.order.service.business.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order);

    void cancelOrder(Order order, List<String> failureMessages);

}
