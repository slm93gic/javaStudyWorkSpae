package com.shenlimin.conf;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackageClasses = {com.shenlimin.service.IBuy.class})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {


}

