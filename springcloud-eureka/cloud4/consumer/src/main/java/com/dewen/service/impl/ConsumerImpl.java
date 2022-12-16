package com.dewen.service.impl;

import com.dewen.client.TestClient;
import com.dewen.service.IConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("consumerImpl")
public class ConsumerImpl implements IConsumer {
    @Autowired
    private TestClient testClient;

    @Override
    public String hello(String name) throws Exception {
        return testClient.test(name);
    }
}
