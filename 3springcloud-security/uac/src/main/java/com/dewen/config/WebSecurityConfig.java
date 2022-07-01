package com.dewen.config;

import com.dewen.security.handler.FailureHandler;
import com.dewen.security.handler.LogoutHandler;
import com.dewen.security.handler.SuccessHandler;
import com.dewen.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private SuccessHandler successHandler;

    @Autowired
    private FailureHandler failureHandler;

    @Autowired
    private LogoutHandler logoutHandler;

    @Autowired
    private CustomUserDetailsService userDetailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * AuthenticationManagerBuilder用于创建AuthenticationManager实例，这个接口就是Spring Security用于认证用户的主要接口。
     * 使用AuthenticationManagerBuilder构建 基于内存的认证，LDAP认证，JDBC 认证，或自定义认证。
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder());

        // auth.inMemoryAuthentication()
        //         .withUser("dewen")
        //         .password("$password")
        //         .roles("admins");
    }

    /**
     * 指定角色和资源的对应关系
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                .loginProcessingUrl("/login").permitAll()
                .successHandler(successHandler).permitAll()
                .failureHandler(failureHandler).permitAll().and()
                .logout().logoutSuccessHandler(logoutHandler).and()
                .authorizeRequests()
                // .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                //     @Override
                //     public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                //         o.setAccessDecisionManager(myAccessDecisionManager);
                //         o.setSecurityMetadataSource(myFilter);
                //         return o;
                //     }
                // })
                // .antMatchers("/admin/**").hasRole("admin")
                // .antMatchers("/db/**").hasRole("dba")
                .antMatchers("/**").permitAll();
    }
}
