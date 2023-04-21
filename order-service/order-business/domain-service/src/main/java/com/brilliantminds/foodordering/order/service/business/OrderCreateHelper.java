package com.brilliantminds.foodordering.order.service.business;

import com.brilliantminds.foodordering.order.service.business.dto.create.CreateOrderCommand;
import com.brilliantminds.foodordering.order.service.business.entity.Customer;
import com.brilliantminds.foodordering.order.service.business.entity.Order;
import com.brilliantminds.foodordering.order.service.business.entity.Restaurant;
import com.brilliantminds.foodordering.order.service.business.event.OrderCreatedEvent;
import com.brilliantminds.foodordering.order.service.business.exception.OrderDomainException;
import com.brilliantminds.foodordering.order.service.business.mapper.OrderDataMapper;
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
public class OrderCreateHelper {

    private final OrderDomainService  orderDomainService;
    private final OrderRepository orderRepository;
    private final OrderDataMapper orderDataMapper;
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;

    public OrderCreateHelper(   OrderDomainService orderDomainService,
                                OrderRepository orderRepository,
                                OrderDataMapper orderDataMapper,
                                CustomerRepository customerRepository,
                                RestaurantRepository restaurantRepository) {
        this.orderDomainService = orderDomainService;
        this.orderRepository = orderRepository;
        this.orderDataMapper = orderDataMapper;
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    public OrderCreatedEvent persistOrder(CreateOrderCommand createOrderCommand) {
        checkCustomer(createOrderCommand.getCustomerId());
        Restaurant restaurant = checkRestaurant(createOrderCommand);
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, restaurant);
        saveOrder(order);
        log.info("Order is created with id {}", orderCreatedEvent.getOrder().getId().getValue());
        return orderCreatedEvent;

    }
    private Restaurant checkRestaurant(CreateOrderCommand createOrderCommand) {
        Restaurant restaurant = orderDataMapper.createOrderCommandToRestaurant(createOrderCommand);
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findRestaurantInformation(restaurant);
        if (optionalRestaurant.isEmpty()) {
            log.warn("Could not find the restaurant with id : {}", createOrderCommand.getRestaurantId());
            throw new OrderDomainException("Could not find the restaurant with id : " + createOrderCommand.getRestaurantId());
        }
        return optionalRestaurant.get();
    }

    private void checkCustomer(UUID customerId) {
        Optional<Customer> customer = customerRepository.findCustomer(customerId);
        if (customer.isEmpty()) {
            log.warn("Could not find the customer with id : {}", customerId);
            throw new OrderDomainException("Could not find the customer with id : " + customerId);
        }
    }

    private Order saveOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        if (savedOrder == null) {
            log.warn("Order could not be saved");
            throw new OrderDomainException("Could not save an order");
        }
        return savedOrder;
    }
}
