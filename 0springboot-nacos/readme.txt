# 配置扩展的配置，因为很多情况项目都需要使用一些公共的配置，比如微服务之间很多公共配置项
  nacos.config.ext-config[0].namespace=common
  nacos.config.ext-config[0].data-id=redisCommon
  nacos.config.ext-config[0].group=test
  nacos.config.ext-config[0].max-retry=1
  nacos.config.ext-config[0].type=properties
  nacos.config.ext-config[0].auto-refresh=true
  nacos.config.ext-config[0].config-retry-time=2333
  nacos.config.ext-config[0].config-long-poll-timeout=46000
  nacos.config.ext-config[0].enable-remote-sync-config=true

  nacos.config.ext-config[1].namespace=first
  nacos.config.ext-config[1].data-id=myDemo.properties
  nacos.config.ext-config[1].group=test
  nacos.config.ext-config[1].max-retry=1
  nacos.config.ext-config[1].type=properties
  nacos.config.ext-config[1].auto-refresh=true
  nacos.config.ext-config[1].config-retry-time=2333
  nacos.config.ext-config[1].config-long-poll-timeout=46000
  nacos.config.ext-config[1].enable-remote-sync-config=true


  1.nacos-config-spring-boot-starter可以实现对@NacosValue注解属性的动态更改，默认无法支持@Value注解的动态更改
  2.spring cloud nacos需要在类上标记@RefreshScope，可以实现@Value注解属性的动态更改

Data ID的格式如下:${prefix}-${spring.profile.active}.${nacos.config.file-extension}

  prefix 默认为 spring.application.name 的值，也可以通过配置项 spring.cloud.nacos.config.prefix来配置。
  spring.profile.active 即为当前环境对应的 profile。 注意：当 spring.profile.active 为空时，对应的连接符 - 也将不存在，dataId 的拼接格式变成 p r e f i x . {prefix}.prefix.{file-extension}。
  nacos.config.file-extension的默认值为properties
  当spring.profiles.active未配置时，则匹配${spring.application.name}.properties
  若设置了spring.profiles.active而Nacos中存在s p r i n g . a p p l i c a t i o n . n a m e . p r o p e r t i e s 时 ， 若 还 存 在 {spring.application.name}.properties时，若还存在spring.application.name.properties时，若还存在{spring.application.name}-${spring.profiles.active}.properties，则默认匹配后者，若不存在，则会自动匹配前者
  file-exetension 为配置内容的数据格式，可以通过配置项 spring.cloud.nacos.config.file-extension来配置。目前只支持 properties 和 yaml 类型。
  由于Nacos建议且默认用spring.application.name作为Data Id的前缀，若要在不同服务中共享项目统一配置，则可以通过配置nacos.config.shared-dataids或nacos.config.refreshable-dataids来添加共享配置，前者不支持自动刷新，后者支持
