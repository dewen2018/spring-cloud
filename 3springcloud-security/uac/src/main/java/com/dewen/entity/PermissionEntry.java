package com.dewen.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_permission")
public class PermissionEntry {

    @TableId
    private Integer id;

    private String code;

    private String description;

    private String url;
}