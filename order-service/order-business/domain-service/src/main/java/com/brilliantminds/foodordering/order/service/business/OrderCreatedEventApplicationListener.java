package com.brilliantminds.foodordering.order.service.business;

import com.brilliantminds.foodordering.order.service.business.event.OrderCreatedEvent;
import com.brilliantminds.foodordering.order.service.business.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMsgPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class OrderCreatedEventApplicationListener {
    private final OrderCreatedPaymentRequestMsgPublisher paymentRequestMsgPublisher;

    public OrderCreatedEventApplicationListener(OrderCreatedPaymentRequestMsgPublisher paymentRequestMsgPublisher) {
        this.paymentRequestMsgPublisher = paymentRequestMsgPublisher;
    }

    @TransactionalEventListener
    void process(OrderCreatedEvent orderCreatedEvent) {

    }
}
