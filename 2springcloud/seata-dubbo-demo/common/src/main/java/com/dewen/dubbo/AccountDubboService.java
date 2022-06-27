package com.dewen.dubbo;


import com.dewen.dto.AccountDTO;
import com.dewen.response.ObjectResponse;

/**
 * 账户服务接口
 */
public interface AccountDubboService {

    /**
     * 从账户扣钱
     */
    ObjectResponse decreaseAccount(AccountDTO accountDTO);
}
