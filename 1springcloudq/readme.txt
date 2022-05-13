Spring Cloud Alibaba Version
    2.2.7.RELEASE
Spring Cloud Version
    Spring Cloud Hoxton.SR12
Spring Boot Version
    2.3.12.RELEASE

Spring Cloud Alibaba Version
    2.2.7.RELEASE
Sentinel Version
    1.8.1
Nacos Version
    2.0.3
RocketMQ Version
    4.6.1
Dubbo Version
    2.7.13
Seata Version
    1.3.0


问题：
1.服务直接可以访问，但是经过网关就访问不了413，原因是网关配置错误，
    - Path=/apiCustomer/*正确为- Path=/apiCustomer/**
2.@NacosValue注解获取不到值，还没有解决
    替代方案：使用@Value和@RefreshScope配合使用
3.整合dubbo后启动报错
    https://github.com/alibaba/spring-cloud-alibaba/issues/2310


支持dubuo，feign失败