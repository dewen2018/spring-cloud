package com.dewen.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dewen.account.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper extends BaseMapper<Account> {

    @Update("update account_info set money = money- #{money} where id = #{accountId}")
    void decrease(@Param("accountId") Long accountId, @Param("money") Integer money);
}
