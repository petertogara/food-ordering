package com.brilliantminds.foodordering.order.service.business.dto.message;

import com.brilliantminds.foodordering.domain.valueobject.OrderApprovalStatus;
import com.brilliantminds.foodordering.domain.valueobject.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantApprovalResponse {
    private String id;
    private String sagaId;
    private String orderId;
    private String restaurantId;
    private Instant createdAt;
    private OrderApprovalStatus approvalStatus;
    private List<String> failureMessages;
}
