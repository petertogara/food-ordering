package com.brilliantminds.foodordering.order.service.business;

import com.brilliantminds.foodordering.order.service.business.entity.Order;
import com.brilliantminds.foodordering.order.service.business.entity.Product;
import com.brilliantminds.foodordering.order.service.business.entity.Restaurant;
import com.brilliantminds.foodordering.order.service.business.event.OrderCancelledEvent;
import com.brilliantminds.foodordering.order.service.business.event.OrderCreatedEvent;
import com.brilliantminds.foodordering.order.service.business.event.OrderPaidEvent;
import com.brilliantminds.foodordering.order.service.business.exception.OrderDomainException;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OrderDomainServiceImpl implements OrderDomainService {

    private final static String UTC = "UTC";

    final Logger LOG = Logger.getLogger(OrderDomainServiceImpl.class.getName());

    @Override
    public OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant) {
        validateRestaurant(restaurant);
        setOrderProductInformation(order, restaurant);
        order.validateOrder();
        order.initializeOrder();
        LOG.log(Level.INFO, "Order with id: {} initialized ", order.getId().getValue());
        return new OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    private void setOrderProductInformation(Order order, Restaurant restaurant) {
        order.getItems().forEach(orderItem -> restaurant.getProducts().forEach(restaurantProduct -> {
                    Product currentProduct = orderItem.getProduct();
                    if (currentProduct.equals(restaurantProduct)) {
                        currentProduct.updateWithConfirmedNameAndPrice(restaurantProduct.getName(),
                                restaurantProduct.getPrice());
                    }
                }
        ));

    }

    private void validateRestaurant(Restaurant restaurant) {
        if (!restaurant.isActive()) {
            throw new OrderDomainException("Selected restaurant with id " + restaurant.getId().getValue()
                    + "is not active");
        }
    }

    @Override
    public OrderPaidEvent payOrder(Order order) {

        order.pay();
        LOG.log(Level.INFO, "Order with id {} paid", order.getId().getValue());
        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public void approveOrder(Order order) {
        order.approve();
        LOG.log(Level.INFO, "Order with id {} approved", order.getId().getValue());
    }

    @Override
    public OrderCancelledEvent cancelOrderPayment(Order order) {
        order.initCancel(order.getFailureMessages());
        LOG.log(Level.INFO, "Order payment is cancelling for order id {}", order.getId().getValue());
        return new OrderCancelledEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {
        order.cancel(failureMessages);
        LOG.log(Level.INFO, "Order is cancelled for order id {}", order.getId().getValue());
    }
}
