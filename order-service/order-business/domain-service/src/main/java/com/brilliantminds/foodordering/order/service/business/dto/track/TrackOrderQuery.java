package com.brilliantminds.foodordering.order.service.business.dto.track;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class TrackOrderQuery {

    @NotNull
    private final UUID orderTrackingId;
}
