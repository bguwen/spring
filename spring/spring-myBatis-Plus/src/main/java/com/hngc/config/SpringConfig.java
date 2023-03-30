package com.hngc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration()
@ComponentScan("com.hngc")
@Import({JdbcConfig.class, MybatisPlusConfig.class})
public class SpringConfig {

}
