package com.dewen.client.hystrixImpl;

import com.dewen.client.TestClient;
import org.springframework.stereotype.Service;

@Service
public class TestClientHystrix implements TestClient {

    @Override
    public String test(String name) {
        return "为找到系统服务者！";
    }
}