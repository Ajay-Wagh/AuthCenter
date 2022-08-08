package com.ajaywagh.authcenter.interceptors.interceptorConfig;

import com.ajaywagh.authcenter.interceptors.HeaderCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private HeaderCheckInterceptor headerCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerCheckInterceptor);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
