package com.libms.api_gateway.route;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.filter.TokenRelayFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {
	
	@Value("${product.service.url}")
	private String productServiceUrl;
	
	@Value("${inventory.service.url}")
	private String inventoryServiceUrl;
	
	@Value("${order.service.url}")
	private String orderServiceUrl;

	@Bean
	RouterFunction<ServerResponse> productServiceRoute()
	{
		return GatewayRouterFunctions.route("product-service")
				.route(RequestPredicates.path("/api/books"), HandlerFunctions.http())
				.before(BeforeFilterFunctions.uri(productServiceUrl))
				.filter(TokenRelayFilterFunctions.tokenRelay())
				.build();
	}
	
	@Bean
    RouterFunction<ServerResponse> productServiceSwaggerRoute() 
	{
        return GatewayRouterFunctions.route("product-service-swagger")
                .route(RequestPredicates.path("/docs/product-service/v3/api-docs"), HandlerFunctions.http())
                .before(BeforeFilterFunctions.stripPrefix(2))
                .before(BeforeFilterFunctions.uri(productServiceUrl))
                .build();
    }
	
	@Bean
	RouterFunction<ServerResponse> inventoryServiceRoute()
	{
		return GatewayRouterFunctions.route("inventory-service")
				.route(RequestPredicates.path("/api/inventory/*"), HandlerFunctions.http())
				.before(BeforeFilterFunctions.uri(inventoryServiceUrl))
				.filter(TokenRelayFilterFunctions.tokenRelay())
				.build();
	}
	
	@Bean
    RouterFunction<ServerResponse> inventoryServiceSwaggerRoute() 
	{
        return GatewayRouterFunctions.route("inventory-service-swagger")
                .route(RequestPredicates.path("/docs/inventory-service/v3/api-docs"), HandlerFunctions.http())
                .before(BeforeFilterFunctions.stripPrefix(2))
                .before(BeforeFilterFunctions.uri(inventoryServiceUrl))
                .build();
    }
	
	@Bean
	RouterFunction<ServerResponse> orderServiceRoute()
	{
		return GatewayRouterFunctions.route("order-service")
				.route(RequestPredicates.path("/api/orders"), HandlerFunctions.http())
				.before(BeforeFilterFunctions.uri(orderServiceUrl))
				.filter(TokenRelayFilterFunctions.tokenRelay())
				.build();
	}
	
	@Bean
    RouterFunction<ServerResponse> orderServiceSwaggerRoute() 
	{
        return GatewayRouterFunctions.route("order-service-swagger")
                .route(RequestPredicates.path("/docs/order-service/v3/api-docs"), HandlerFunctions.http())
                .before(BeforeFilterFunctions.stripPrefix(2))
                .before(BeforeFilterFunctions.uri(orderServiceUrl))
                .build();
    }
}
