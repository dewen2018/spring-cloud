package com.dewen.controller;

import com.dewen.service.IConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private IConsumer consumerImpl;

    @GetMapping("/sendName")
    public String sendName(@RequestParam String name){
        try {
            return consumerImpl.hello(name);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}