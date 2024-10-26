package com.yfsystem.config;

import com.yfsystem.interceptors.YfInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;

/**
 * ClassName WebInitConfig
 * Author OuYangYiFan
 * Description TODO
 * DATA 2024/10/22 下午11:35
 * Version 1.0
 */
@Configuration
public class WebInitConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new YfInterceptor()).addPathPatterns("/**").order(1);
    }

}
