package com.frans.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 首页所有人可以访问，功能页有权限
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level2/**").hasRole("vip3");


        // 登录
        http.formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new Pbkdf2PasswordEncoder())
                .withUser("frans").password(new Pbkdf2PasswordEncoder().encode("123")).roles("vip2", "vip3")
                .and()
                .withUser("root").password(new Pbkdf2PasswordEncoder().encode("123")).roles("vip1","vip3","vip2")
                .and()
                .withUser("guest").password(new Pbkdf2PasswordEncoder().encode("123")).roles("vip1");
    }
}
