package com.__project01.foodBlog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //웹페이지에서 사용할 경로
    private String resourcePath = "/upload/**";
    
    //업로드된 파일이 저장될 경로
    private String savePath = "file:///C:/development/intellij_community/spring_upload_files/";

    //WebMvcConfigurer 포함 메소드 addResourceHandlers 재정의
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(resourcePath)
                .addResourceLocations(savePath);
    }
}
