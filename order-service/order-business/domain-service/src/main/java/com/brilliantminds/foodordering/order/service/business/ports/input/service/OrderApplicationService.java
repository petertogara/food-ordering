package com.brilliantminds.foodordering.order.service.business.ports.input.service;

import com.brilliantminds.foodordering.order.service.business.dto.create.CreateOrderCommand;
import com.brilliantminds.foodordering.order.service.business.dto.create.CreateOrderResponse;
import com.brilliantminds.foodordering.order.service.business.dto.track.TrackOrderQuery;
import com.brilliantminds.foodordering.order.service.business.dto.track.TrackOrderResponse;
import jakarta.validation.Valid;

public interface OrderApplicationService {

    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);

    TrackOrderResponse trackOrder(@Valid  TrackOrderQuery trackOrderQuery);

}
