package com.site.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // controller,service,mapper,repository,configuration,bean,component
public class FileConfig implements WebMvcConfigurer {
	
	@Override // webMvcConfigurer 상속하면 addResourceHandlers 구현해야 함.
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// URL이 upload라고 들어오면, 파일을 c:upload에서 검색
		registry.addResourceHandler("/upload/**")
		.addResourceLocations("file:///c:/upload/");
		
	}

}
