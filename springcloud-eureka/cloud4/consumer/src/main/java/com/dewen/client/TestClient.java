package com.dewen.client;


import com.dewen.client.hystrixImpl.TestClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider",path = "/provider",fallback = TestClientHystrix.class)
//@FeignClient(value = "common-wx", url = "www.baidu.com/common-wx")
public interface TestClient {
    @GetMapping(value = "/test")
    String test(@RequestParam String name);
}