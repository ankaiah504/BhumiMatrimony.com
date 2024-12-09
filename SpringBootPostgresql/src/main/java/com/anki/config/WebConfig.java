package com.anki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.anki.interceptor.LoggerInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	
	  @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(new LoggerInterceptor())
	                .order(1);
//	        registry.addInterceptor(new BasicAuthHandlerInterceptor())
//	                .order(1)
//	                .addPathPatterns("/products/new");

	    }
}
