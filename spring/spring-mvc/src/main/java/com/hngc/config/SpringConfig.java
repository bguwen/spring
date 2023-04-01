package com.hngc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring配置类
 */
//声明为配置类
@Configuration
//扫Bean
@ComponentScan({"com.hngc.service"})
//配置文件
@PropertySource("classpath:jdbc.properties")
//导入配置
@Import({JdbcConfig.class, MyBatisConfig.class})
//开启注解事务功能
@EnableTransactionManagement
public class SpringConfig {
}
