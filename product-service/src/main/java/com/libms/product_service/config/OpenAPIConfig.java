package com.libms.product_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

    @Bean
    OpenAPI customOpenAPIBean() {
        return new OpenAPI()
            .info(new Info()
                .title("Product Service API")	
                .description("Product Service API for Library Management System")
                .version("1.0"));
    }
}
