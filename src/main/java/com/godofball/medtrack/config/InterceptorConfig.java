package com.godofball.medtrack.config;

import com.godofball.medtrack.interceptor.AdminLoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminLoginCheckInterceptor()).addPathPatterns("/**").
                excludePathPatterns(
                        "/admin/login",
                        "/admin/logout",
                        "/backend/**");
    }
}
