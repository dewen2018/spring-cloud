package com.dewen.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("product-server")
public interface ProductClient {

    @PutMapping("/minus/stock")
    void minusStock(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
