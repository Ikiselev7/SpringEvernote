package com.epam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.epam.dao", "com.epam.services", "com.epam.config.db"})
public class AppConfig {

    // TODO: 10.12.2017 Implement that if necessery, or use Spring Boot

}
