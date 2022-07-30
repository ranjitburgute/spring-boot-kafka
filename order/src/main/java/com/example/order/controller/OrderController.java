package com.example.order.controller;

import com.example.model.OrderEvent;
import com.example.order.kafka.OrderProducer;
import com.example.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/orders")
    public String createOrder(@RequestBody Order order){
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setOrder(order);
        orderEvent.setState("NEW");

        orderProducer.createOrder(orderEvent);

        LOGGER.info("Order created successfully..." + order.toString());
        return "Order created successfully...";
    }
}
