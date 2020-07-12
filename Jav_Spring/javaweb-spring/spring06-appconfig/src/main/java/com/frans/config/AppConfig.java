package com.frans.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(FransConfig.class)
public class AppConfig {
}
