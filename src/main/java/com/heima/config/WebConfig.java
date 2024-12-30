package com.heima.config;

import com.heima.interceptor.JwtInterceptor;
import com.heima.interceptor.JwtTokenAdminInterceptor;
import com.heima.utils.JwtProperties;
import com.heima.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Autowired
    private JwtInterceptor jwtInterceptor;
    @Autowired
    private JwtTokenAdminInterceptor jwtTokenAdminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtTokenAdminInterceptor)
                .addPathPatterns("**")
                .excludePathPatterns(
                    "/users/login"
                );
    }
    @Bean
    public JwtInterceptor jwtInterceptor(){
        return new JwtInterceptor();
    }
    @Bean
    public JwtUtil JwtUtil(){
        return new JwtUtil();
    }
    @Bean
    public JwtTokenAdminInterceptor JwtProperties(){
        return new  JwtTokenAdminInterceptor();
    }

} 