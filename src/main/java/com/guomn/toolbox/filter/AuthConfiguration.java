package com.guomn.toolbox.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

/**
 *认证相关配置
 */
@Configuration
public class AuthConfiguration extends WebMvcConfigurerAdapter {
    @Value("${contactFilter.excludePathPatterns}")
    public String excludePathPatterns;
    @Value("${contactFilter.addPathPatterns}")
    public String addPathPatterns;
    @Bean
    public AuthInterceptor contactAuthInterceptor(){
        return new AuthInterceptor();
    }

    @Bean
    public WebMvcConfigurer contactWebMvcConfigurer(){
        return new WebMvcConfigurer(){
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                InterceptorRegistration addInterceptor = registry.addInterceptor(contactAuthInterceptor());
                // 排除配置
                addInterceptor.excludePathPatterns(Arrays.asList(excludePathPatterns.split(",")));
                // 拦截配置
                addInterceptor.addPathPatterns(Arrays.asList(addPathPatterns.split(",")));
            }
        };
    }

}
