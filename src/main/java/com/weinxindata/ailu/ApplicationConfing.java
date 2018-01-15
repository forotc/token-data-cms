package com.weinxindata.ailu;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.weinxindata.ailu.interceptor.SessionInterceptor;

@Configuration
public class ApplicationConfing implements WebMvcConfigurer {

	public void addInterceptors(InterceptorRegistry registry) {
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/center");
	}
}
