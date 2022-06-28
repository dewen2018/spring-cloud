package com.dewen.order.controller;

import com.dewen.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/seata/test")
    public ResponseEntity<Void> seataDemo(Boolean hasError) {
        orderService.seataDemo(hasError);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}