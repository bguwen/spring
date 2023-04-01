package com.hngc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * SpringMVC配置类
 */
@Configuration
@ComponentScan({"com.hngc.controller", "com.hngc.config"})
//开启SpringMVC
@EnableWebMvc
public class SpringMvcConfig {
}