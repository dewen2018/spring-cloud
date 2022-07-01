package com.dewen;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// @SpringBootTest
public class ForTest {
    /**
     * 同一串字符每次加密产生的结构不同，这就实现了密码的加密
     */
    @Test
    void contextLoads() {
        for (int i = 0; i < 10; i++) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            System.out.println(encoder.encode("123"));
        }
    }
}
