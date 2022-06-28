问题：
1.服务直接可以访问，但是经过网关就访问不了413，原因是网关配置错误，
    - Path=/apiCustomer/*正确为- Path=/apiCustomer/**
2.@NacosValue注解获取不到值，还没有解决
    替代方案：使用@Value和@RefreshScope配合使用
3.整合dubbo后启动报错
    https://github.com/alibaba/spring-cloud-alibaba/issues/2310

本demo功能
    支持dubuo，feign 两个远程调用，相对来说Dubbo较feign会节省时间
    本人本地环境测试，大致相差1ms~

打包：
1.通过revision控制版本
2.打包只需要在父节点package
3.maven必须要skipTests和execution repackage

