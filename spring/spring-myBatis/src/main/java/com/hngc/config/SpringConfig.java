package com.hngc.config;

import org.springframework.context.annotation.*;


@Configuration()
@ComponentScan("com.hngc")
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {

}
