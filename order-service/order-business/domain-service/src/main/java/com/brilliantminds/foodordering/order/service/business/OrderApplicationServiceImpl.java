package com.brilliantminds.foodordering.order.service.business;

import com.brilliantminds.foodordering.order.service.business.dto.create.CreateOrderCommand;
import com.brilliantminds.foodordering.order.service.business.dto.create.CreateOrderResponse;
import com.brilliantminds.foodordering.order.service.business.dto.track.TrackOrderQuery;
import com.brilliantminds.foodordering.order.service.business.dto.track.TrackOrderResponse;
import com.brilliantminds.foodordering.order.service.business.ports.input.service.OrderApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
class OrderApplicationServiceImpl implements OrderApplicationService {

    private final  OrderCreateCommandHandler orderCreateCommandHandler;

    private final OrderTrackCommandHandler orderTrackCommandHandler;

    public OrderApplicationServiceImpl(OrderCreateCommandHandler orderCreateCommandHandler,
                                       OrderTrackCommandHandler orderTrackCommandHandler) {
        this.orderCreateCommandHandler = orderCreateCommandHandler;
        this.orderTrackCommandHandler = orderTrackCommandHandler;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        return orderCreateCommandHandler.createOrder(createOrderCommand);
    }

    @Override
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        return orderTrackCommandHandler.trackOrder(trackOrderQuery);

    }
}
