package com.dewen.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Dewen
 * @date 2022/5/13 17:11:24
 */

@FeignClient(value = "api-server")
public interface RCOpenfeignClient {

    @GetMapping("/apiServer/user/getUserName/{userId}")
    String getUserName(@PathVariable(value = "userId") String userId);
}
