package com.dewen.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class TokenConfig {

    /**
     * 秘钥串
     */
    private static final String SIGNING_KEY = "uac";

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    /**
     * 这里我们设置了一个JWT加密所使用的密钥。对于JWT的加密，支持对称加密和非对称加密，
     * 非对称加密需要在服务端生成一个密钥对（公钥和私钥），每一个需要使用JWT的客户端都可以获取到公钥，
     * 并可以使用公钥对JWT进行解密和认证。对于公钥和私钥的生成需要一个证书，
     * 相对来说比较麻烦，本项目直接采用对称加密的方式
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }
}
