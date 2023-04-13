package com.brilliantminds.foodordering.order.service.business.ports.output.respository;

import com.brilliantminds.foodordering.domain.valueobject.TrackingId;
import com.brilliantminds.foodordering.order.service.business.entity.Order;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);
    Optional<Order> findByTrackingId(TrackingId trackingId);

}
