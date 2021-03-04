package com.yonghui.o2o.support.idaas.cas.client;

import com.cas.starter.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableCasClient
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.yonghui.o2o.support.idaas.cas.client"})
public class SpringbootO2oSupportIdaasCasClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootO2oSupportIdaasCasClientApplication.class, args);
	}
}

