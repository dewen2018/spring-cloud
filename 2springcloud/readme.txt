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
3.集成sentinel的时候，bootstrap.ymlg格式写错了，导致控制台一直看不到数据
    另外因为有一定的延迟，所以要稍等几秒钟，另外第一次必须要先访问一下接口
4.mavenclean需要搞一下

端口定义：
    gateway网关：80
    sentinel控制台81
    actuator监控：82
    nacos注册及配置中心：8848
    seata
    内网服务：7000开始
        server
    内网服务sentinel端口7500，服务端口号顺延500

依赖说明：
    1.如果使用sentinel，需要更改依赖：dp-sentinel，因为目前业务使用不到，不作为必须依赖

