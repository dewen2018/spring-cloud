// package com.dewen.config;
//
// @Component
// public class MyAccessDecisionManager implements AccessDecisionManager {
//     @Override
//     public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
//         for (ConfigAttribute attribute : collection) {
//             if ("ROLE_login".equals(attribute.getAttribute())) {
//                 //判断是否登录，若是匿名用户则表示没有登录，抛出异常
//                 if (authentication instanceof AnonymousAuthenticationToken) {
//                     throw new AccessDeniedException("非法请求！");
//                 } else break;
//             }
//             //获取当前用户具备的角色
//             Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//             for (GrantedAuthority authority : authorities) {
//                 if (authority.getAuthority().equals(attribute.getAttribute())) {
//                     break;
//                 }
//             }
//         }
//         throw new AccessDeniedException("非法请求！");
//     }
//
//     @Override
//     public boolean supports(ConfigAttribute configAttribute) {
//         return true;
//     }
//
//     @Override
//     public boolean supports(Class<?> aClass) {
//         return true;
//     }
// }