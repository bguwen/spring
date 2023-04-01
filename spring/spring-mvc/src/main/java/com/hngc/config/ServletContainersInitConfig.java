//package com.hngc.config;
//
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;
//
///**
// * Servlet配置类
// */
//public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
//    //加载springmvc配置类
//    @Override
//    protected WebApplicationContext createServletApplicationContext() {
//        //初始化WebApplicationContext对象
//        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
//        //加载指定配置类
//        webApplicationContext.register(SpringConfig.class);
//        return webApplicationContext;
//    }
//    //设置由springmvc控制器处理的请求映射路径
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//    //加载spring配置类
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        //初始化WebApplicationContext对象
//        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
//        //加载指定配置类
//        webApplicationContext.register(SpringConfig.class);
//        return webApplicationContext;
//    }
//}