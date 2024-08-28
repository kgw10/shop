package com.shop.config;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configurable
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${uploadPath}")
    String uploadPath;

    // 실제 업로드 경로와 웹에서 사용할 주소를 연결, 실제 업로드 경로는 웹에서 사용할 수 없는 경로이기 때문에 웹용으로 /images/를 쓰겠다.라고 등록
    // 웹에서 /images/12.jpg라는 이미지 요청이 들어오면 실제 경로 C:/shop/12.jpg의 이미지를 제공한다.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/images/**")
                .addResourceLocations(uploadPath);

    }
}
