package com.wk.springBootDemo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 *项目启动类
 */
//@ComponentScan告诉Spring哪个packages用注解的类会被自动扫描并装入bean容器
//扫描其他类，相当于spring xml配置中的context:component-scan
@ComponentScan(basePackages="com.wk.springBootDemo")
@EnableAutoConfiguration//spring boot配置的核心入口
public class SampleApplication{

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleApplication.class, args);
    }
}