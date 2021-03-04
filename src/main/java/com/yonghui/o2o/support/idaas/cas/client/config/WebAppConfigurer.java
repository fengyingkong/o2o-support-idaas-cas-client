package com.yonghui.o2o.support.idaas.cas.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chensong
 * Date on  2021/3/1
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    @Bean
    public SecurityInterceptor myInterceptor() {
        return new SecurityInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/v1/login");

    }
}
