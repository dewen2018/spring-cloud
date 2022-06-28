package com.dewen.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("account_info")
public class Account {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Integer money;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
