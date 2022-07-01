// package com.dewen.config;
//
// import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
// import org.springframework.stereotype.Component;
//
// /**
//  * 动态权限配置就是要将权限也存入数据库中，通过数据库中数据之间的关系来确定权限。
//  */
// @Component
// public class MyFilter implements FilterInvocationSecurityMetadataSource {
//     //路径匹配符
//     AntPathMatcher pathMatcher = new AntPathMatcher();
//     @Autowired
//     MenuService menuService;
//
//     //根据请求地址，分析请求需要的角色
//     @Override
//     public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
//         String requestUrl = ((FilterInvocation) o).getRequestUrl();
//         List<Menu> allMenus = menuService.getAllMenus();
//         for (Menu menu : allMenus) {
//             if (pathMatcher.match(menu.getPattern(), requestUrl)) {
//                 List<Role> roles = menu.getRoles();
//                 String[] rolesStr = new String[roles.size()];
//                 for (int i = 0; i < roles.size(); i++) {
//                     rolesStr[i] = roles.get(i).getName();
//                 }
//                 return SecurityConfig.createList(rolesStr);
//             }
//         }
//         return SecurityConfig.createList("ROLE_login");
//     }
//
//     @Override
//     public Collection<ConfigAttribute> getAllConfigAttributes() {
//         return null;
//     }
//
//     @Override
//     public boolean supports(Class<?> aClass) {
//         return true;
//     }
// }