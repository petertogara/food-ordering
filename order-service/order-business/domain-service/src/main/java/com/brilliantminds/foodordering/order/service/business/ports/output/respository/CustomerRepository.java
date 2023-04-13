package com.brilliantminds.foodordering.order.service.business.ports.output.respository;

import com.brilliantminds.foodordering.order.service.business.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<Customer> findCustomer(UUID customerId);
}
