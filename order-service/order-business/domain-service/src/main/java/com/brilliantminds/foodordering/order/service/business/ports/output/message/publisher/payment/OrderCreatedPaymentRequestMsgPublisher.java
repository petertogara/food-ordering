package com.brilliantminds.foodordering.order.service.business.ports.output.message.publisher.payment;

import com.brilliantminds.foodordering.domain.event.publisher.DomainEventPublisher;
import com.brilliantminds.foodordering.order.service.business.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMsgPublisher extends DomainEventPublisher<OrderCreatedEvent> {
}
