package com.dewen.account.service;

import com.dewen.account.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Transactional
    public void decrease(Long accountId, Integer money) {
        accountMapper.decrease(accountId, money);
    }
}