package com.dewen.controller;

import com.dewen.service.ITAccountService;
import com.dewen.dto.AccountDTO;
import com.dewen.response.ObjectResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 账户扣钱
 * </p>
 *
 * * @author lidong
 *
 * @since 2019-09-04
 */
@RestController
@RequestMapping("/account")
@Slf4j
public class TAccountController {

    @Autowired
    private ITAccountService accountService;

    @PostMapping("/dec_account")
    ObjectResponse decreaseAccount(@RequestBody AccountDTO accountDTO) {
        log.info("请求账户微服务：{}", accountDTO.toString());
        return accountService.decreaseAccount(accountDTO);
    }
}

