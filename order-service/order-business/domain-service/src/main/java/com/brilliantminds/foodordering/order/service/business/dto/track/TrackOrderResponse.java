package com.brilliantminds.foodordering.order.service.business.dto.track;

import com.brilliantminds.foodordering.domain.valueobject.OrderStatus;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class TrackOrderResponse {
    @NotNull
    private final UUID trackingOrderId;
    @NotNull
    private final OrderStatus orderStatus;
    private final List<String> failureMessages;
}
