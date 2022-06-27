package com.dewen.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dewen.dto.AccountDTO;
import com.dewen.entity.TAccount;
import com.dewen.enums.RspStatusEnum;
import com.dewen.mapper.TAccountMapper;
import com.dewen.response.ObjectResponse;
import org.springframework.stereotype.Service;

@Service
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements ITAccountService {

    @Override
    public ObjectResponse decreaseAccount(AccountDTO accountDTO) {
        int account = baseMapper.decreaseAccount(accountDTO.getUserId(), accountDTO.getAmount().doubleValue());
        ObjectResponse<Object> response = new ObjectResponse<>();
        if (account > 0) {
            response.setStatus(RspStatusEnum.SUCCESS.getCode());
            response.setMessage(RspStatusEnum.SUCCESS.getMessage());
            return response;
        }

        response.setStatus(RspStatusEnum.FAIL.getCode());
        response.setMessage(RspStatusEnum.FAIL.getMessage());
        return response;
    }
}
