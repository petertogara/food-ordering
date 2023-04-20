package com.brilliantminds.foodordering.order.service.business;

import com.brilliantminds.foodordering.order.service.business.dto.create.CreateOrderCommand;
import com.brilliantminds.foodordering.order.service.business.dto.create.OrderAddress;
import com.brilliantminds.foodordering.order.service.business.dto.create.OrderItem;
import com.brilliantminds.foodordering.order.service.business.mapper.OrderDataMapper;
import com.brilliantminds.foodordering.order.service.business.ports.input.service.OrderApplicationService;
import com.brilliantminds.foodordering.order.service.business.ports.output.respository.CustomerRepository;
import com.brilliantminds.foodordering.order.service.business.ports.output.respository.OrderRepository;
import com.brilliantminds.foodordering.order.service.business.ports.output.respository.RestaurantRepository;
import net.bytebuddy.build.CachedReturnPlugin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.zip.CRC32;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = OrderTestConfiguration.class)
public class OrderApplicationServiceTest {

    @Autowired
    private OrderApplicationService orderApplicationService;
    @Autowired
    private OrderDataMapper orderDataMapper;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    private CreateOrderCommand createOrderCommand;
    private CreateOrderCommand createOrderCommandWrongPrice;
    private CreateOrderCommand createOrderCommandWrongProductPrice;
    private final  UUID CUSTOMER_ID = java.util.UUID.fromString("5f116d22-d14c-4816-b217-92c35400d742");
    private final  UUID RESTAURANT_ID = java.util.UUID.fromString("92c35400-4816-d14c-4816-92c355f116d22");
    private final  UUID PRODUCT_ID = java.util.UUID.fromString("058975-78-11e5024212000210-959799");
    private final  UUID ORDER_ID = java.util.UUID.fromString("ce68e17f-4a5f-42b8-b9fd-7b65b70fa6ed");
    private final BigDecimal PRICE =  new BigDecimal("200.00");

    @BeforeAll
    public void init(){
        createOrderCommand = CreateOrderCommand.builder()
                .customerId(CUSTOMER_ID)
                .restaurantId(RESTAURANT_ID)
                .address(OrderAddress.builder()
                        .postalCode("52-131")
                        .street("Adama Kopycinskiego")
                        .city("Wroclaw")
                        .build())
                .price(PRICE)
                .items(List.of(OrderItem.builder()
                        .productId(PRODUCT_ID)
                        .quantity(1)
                        .price(new BigDecimal("50.00"))
                        .subTotal(new BigDecimal("50.00"))
                        .build()))
                .build();
    }

}
