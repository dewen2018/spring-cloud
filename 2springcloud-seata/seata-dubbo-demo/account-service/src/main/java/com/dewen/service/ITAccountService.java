package com.dewen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dewen.dto.AccountDTO;
import com.dewen.entity.TAccount;
import com.dewen.response.ObjectResponse;

public interface ITAccountService extends IService<TAccount> {

    /**
     * 扣用户钱
     */
    ObjectResponse decreaseAccount(AccountDTO accountDTO);
}
