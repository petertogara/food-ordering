package com.brilliantminds.foodordering.order.service.business;

import com.brilliantminds.foodordering.domain.valueobject.TrackingId;
import com.brilliantminds.foodordering.order.service.business.dto.track.TrackOrderQuery;
import com.brilliantminds.foodordering.order.service.business.dto.track.TrackOrderResponse;
import com.brilliantminds.foodordering.order.service.business.entity.Order;
import com.brilliantminds.foodordering.order.service.business.exception.OrderNotFoundException;
import com.brilliantminds.foodordering.order.service.business.mapper.OrderDataMapper;
import com.brilliantminds.foodordering.order.service.business.ports.output.respository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class OrderTrackCommandHandler {

    private final OrderDataMapper orderDataMapper;
    private final OrderRepository orderRepository;

    public OrderTrackCommandHandler(OrderDataMapper orderDataMapper, OrderRepository orderRepository) {
        this.orderDataMapper = orderDataMapper;
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        Optional<Order> trackingResult =
                orderRepository.findByTrackingId(new TrackingId(trackOrderQuery.getOrderTrackingId()));
        if (trackingResult.isEmpty()) {
            log.warn("Could not find an order with id: {}", trackOrderQuery.getOrderTrackingId());
            throw new OrderNotFoundException("Could not find an order with id: "
                    + trackOrderQuery.getOrderTrackingId());
        }
        return orderDataMapper.orderToTrackOrderResponse(trackingResult.get());
    }
}
