package com.meal.vortex.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.meal.vortex","com.meal.vortex.config"})
public class RootConfig {
}
