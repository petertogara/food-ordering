package com.brilliantminds.foodordering.order.service.business.ports.output.respository;

import com.brilliantminds.foodordering.order.service.business.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {

    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
