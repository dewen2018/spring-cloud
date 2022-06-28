package com.dewen.account.service.impl;

import com.dewen.account.mapper.AccountMapper;
import com.dewen.account.service.IAccount;
import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class AccountService implements IAccount {

    @Resource
    private AccountMapper accountMapper;

    /**
     * 扣减账户余额
     *
     * @param accountId
     * @param money
     */
    @Override
    public void decrease(Long accountId, Integer money) {
        accountMapper.decrease(accountId, money);
        log.info("当前XID===>" + RootContext.getXID());
        log.info("扣减账户余额");
    }

    @Override
    public boolean commit(BusinessActionContext context) {
        log.info(context.getActionName() + ",xid-" + context.getXid() + "二阶段提交");
        return true;
    }

    @Override
    public boolean cancel(BusinessActionContext context) {
        log.info("xid-" + context.getXid() + "二阶段回滚");
        return true;
    }
}