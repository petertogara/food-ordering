package com.brilliantminds.foodordering.order.service.business.mapper;


import com.brilliantminds.foodordering.domain.valueobject.CustomerId;
import com.brilliantminds.foodordering.domain.valueobject.Money;
import com.brilliantminds.foodordering.domain.valueobject.ProductId;
import com.brilliantminds.foodordering.domain.valueobject.RestaurantId;
import com.brilliantminds.foodordering.order.service.business.dto.create.CreateOrderCommand;
import com.brilliantminds.foodordering.order.service.business.dto.create.CreateOrderResponse;
import com.brilliantminds.foodordering.order.service.business.dto.create.OrderAddress;
import com.brilliantminds.foodordering.order.service.business.dto.track.TrackOrderResponse;
import com.brilliantminds.foodordering.order.service.business.entity.Order;
import com.brilliantminds.foodordering.order.service.business.entity.OrderItem;
import com.brilliantminds.foodordering.order.service.business.entity.Product;
import com.brilliantminds.foodordering.order.service.business.entity.Restaurant;
import com.brilliantminds.foodordering.order.service.business.valueobject.StreetAddress;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper {

    public Restaurant createOrderCommandToRestaurant(CreateOrderCommand createOrderCommand) {
        return Restaurant.builder()
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .products(createOrderCommand.getItems().stream().map(orderItem ->
                        new Product(new ProductId(orderItem.getProductId())))
                        .collect(Collectors.toList()))
                .build();
    }

    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .customerId(new CustomerId(createOrderCommand.getCustomerId()))
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrderItemEntities(createOrderCommand.getItems()))
                .build();
    }

    private List<OrderItem> orderItemsToOrderItemEntities(
            List<com.brilliantminds.foodordering.order.service.business.dto.create.OrderItem> items) {
        return items.stream()
                .map(orderItem ->
                        OrderItem.builder()
                                .product(new Product(new ProductId(orderItem.getProductId())))
                                .price(new Money(orderItem.getPrice()))
                                .quantity(orderItem.getQuantity())
                                .subTotal(new Money(orderItem.getSubTotal()))
                                .build()).collect(Collectors.toList());
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress address) {
        return new StreetAddress(
                UUID.randomUUID(),
                address.getStreet(),
                address.getPostalCode(),
                address.getCity()
        );
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order savedOrder, String message) {
        return CreateOrderResponse.builder()
                .orderTrackingId(savedOrder.getTrackingId().getValue())
                .orderStatus(savedOrder.getOrderStatus())
                .message(message)
                .build();
    }

    public TrackOrderResponse orderToTrackOrderResponse(Order order) {
        return TrackOrderResponse.builder()
                .trackingOrderId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .failureMessages(order.getFailureMessages())
                .build();
    }
}
