package com.brilliantminds.foodordering.order.service.business;

import com.brilliantminds.foodordering.order.service.business.ports.output.message.publisher.payment.OrderCancelledPaymentRequestMsgPublisher;
import com.brilliantminds.foodordering.order.service.business.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMsgPublisher;
import com.brilliantminds.foodordering.order.service.business.ports.output.message.publisher.restaurantapproval.OrderPaidRestaurantRequestMsgPublisher;
import com.brilliantminds.foodordering.order.service.business.ports.output.respository.CustomerRepository;
import com.brilliantminds.foodordering.order.service.business.ports.output.respository.OrderRepository;
import com.brilliantminds.foodordering.order.service.business.ports.output.respository.RestaurantRepository;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.brilliantminds.foodordering")
public class OrderTestConfiguration {
    @Bean
    public OrderCreatedPaymentRequestMsgPublisher orderCreatedPaymentRequestMsgPublisher() {
        return Mockito.mock(OrderCreatedPaymentRequestMsgPublisher.class);
    }

    @Bean
    public OrderCancelledPaymentRequestMsgPublisher orderCancelledPaymentRequestMsgPublisher() {
        return Mockito.mock(OrderCancelledPaymentRequestMsgPublisher.class);
    }

    @Bean
    public OrderPaidRestaurantRequestMsgPublisher orderPaidRestaurantRequestMsgPublisher() {
        return Mockito.mock(OrderPaidRestaurantRequestMsgPublisher.class);
    }

    @Bean
    public OrderRepository orderRepository() {
        return Mockito.mock(OrderRepository.class);
    }

    @Bean
    public CustomerRepository customerRepository() {
        return Mockito.mock(CustomerRepository.class);
    }

    @Bean
    public RestaurantRepository restaurantRepository() {
        return Mockito.mock(RestaurantRepository.class);
    }
    @Bean
    public OrderDomainService orderDomainService(){
        return new OrderDomainServiceImpl();
    }
}
