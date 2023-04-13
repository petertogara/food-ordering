package com.brilliantminds.foodordering.order.service.business.ports.input.message.listener.payment;

import com.brilliantminds.foodordering.order.service.business.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {

    void paymentCompleted(PaymentResponse paymentResponse);

    void paymentCancelled(PaymentResponse paymentResponse);
}
