package com.brilliantminds.foodordering.order.service.business;

import com.brilliantminds.foodordering.order.service.business.dto.create.CreateOrderCommand;
import com.brilliantminds.foodordering.order.service.business.dto.create.CreateOrderResponse;
import com.brilliantminds.foodordering.order.service.business.entity.Customer;
import com.brilliantminds.foodordering.order.service.business.ports.output.respository.CustomerRepository;
import com.brilliantminds.foodordering.order.service.business.ports.output.respository.OrderRepository;
import com.brilliantminds.foodordering.order.service.business.ports.output.respository.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderCreateCommandHandler {

    private final OrderDomainService orderDomainService;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;

    public OrderCreateCommandHandler(OrderDomainService orderDomainService,
                                     CustomerRepository customerRepository,
                                     OrderRepository orderRepository,
                                     RestaurantRepository restaurantRepository) {
        this.orderDomainService = orderDomainService;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        checkCustomer(createOrderCommand.getCustomerId());
        return null;
    }

    private void checkCustomer(UUID customerId) {
        Optional<Customer> customer = customerRepository.findCustomer(customerId);
    }
}
