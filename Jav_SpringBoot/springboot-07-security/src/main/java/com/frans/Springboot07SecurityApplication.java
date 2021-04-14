package com.frans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Springboot07SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot07SecurityApplication.class, args);
    }

}
