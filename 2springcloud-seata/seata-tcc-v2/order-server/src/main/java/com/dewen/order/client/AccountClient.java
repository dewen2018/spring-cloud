package com.dewen.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("account-server")
@RequestMapping("/account")
public interface AccountClient {

    @RequestMapping("/decrease")
    void decrease(@RequestParam("accountId") Long accountId, @RequestParam("money") Integer money);
}
