package com.tenco.bank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tenco.bank.handler.AuthInterceptor;

import lombok.RequiredArgsConstructor;

@Configuration  // 하나의 클래스를 IoC 하고싶다면 사용
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer{

	@Autowired // DI
	private AuthInterceptor authInterceptor;

	// @RequiredArgsCostructor <-- 생성자 대신 사용가능
	
	// 우리가 만들어 놓은 AuthInterceptior를 등록해야 함
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	
		registry.addInterceptor(authInterceptor).addPathPatterns("/account/**").addPathPatterns("/auth/**");
	}
	
}
