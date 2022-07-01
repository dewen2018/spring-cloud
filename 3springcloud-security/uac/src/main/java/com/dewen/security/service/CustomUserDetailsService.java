package com.dewen.security.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.common.utils.CollectionUtils;
import com.dewen.entity.PermissionEntry;
import com.dewen.service.PermissionService;
import com.dewen.service.UserService;
import com.dewen.uac.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 为验证用户和实现各种基于角色的检查，Spring Security需要我们提供用户的一些信息。
 * 因此，他存在一个名为UserDetailService的接口，内容为通过username检索返回User相关信息。
 * 实现了UserDetailsService接口并且提供了一个loadUserByUsername的具体实现。
 * 注意，loadUserByUsername方法返回一个UserDetails对象，而Spring Security正需要他用于进行各种认证与基于角色的验证。
 */
@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;


    @Override
    public UserDetails loadUserByUsername(String username) {

        UserEntity user = userService.getUserByUsername(username);
        if (user == null) {
            return null;
        }
        //获取权限
        List<PermissionEntry> permissions = permissionService.getPermissionsByUserId(user.getId());
        List<String> codes = permissions.stream().map(PermissionEntry::getCode).collect(Collectors.toList());
        String[] authorities = null;
        if (CollectionUtils.isNotEmpty(codes)) {
            authorities = new String[codes.size()];
            codes.toArray(authorities);
        }
        //身份令牌
        String principal = JSON.toJSONString(user);
        return User.withUsername(principal).password(user.getPassword()).authorities(authorities).build();
    }
}