package com.brilliantminds.foodordering.order.service.business.ports.input.message.listener.restaurantapproval;

import com.brilliantminds.foodordering.order.service.business.dto.message.RestaurantApprovalResponse;

public interface RestaurantApprovalResponseMessageListener {

    void orderApproved(RestaurantApprovalResponse response);

    void orderRejected(RestaurantApprovalResponse response);
}
