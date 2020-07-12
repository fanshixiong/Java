package com.frans.config;


import com.frans.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.frans.pojo")
public class FransConfig {
    @Bean
    public User getUser(){
        return new User();
    }
}
