package com.dewen.uac.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_user")
@Data
public class UserEntity {
    @TableId
    private Integer id;

    private String username;

    private String password;

    private String fullname;
}