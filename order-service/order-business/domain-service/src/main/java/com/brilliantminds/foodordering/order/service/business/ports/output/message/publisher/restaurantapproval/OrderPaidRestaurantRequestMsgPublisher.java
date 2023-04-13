package com.brilliantminds.foodordering.order.service.business.ports.output.message.publisher.restaurantapproval;

import com.brilliantminds.foodordering.domain.event.publisher.DomainEventPublisher;
import com.brilliantminds.foodordering.order.service.business.event.OrderPaidEvent;

public interface OrderPaidRestaurantRequestMsgPublisher extends DomainEventPublisher<OrderPaidEvent> {
}
