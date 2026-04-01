package com.libms.order_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.libms.order_service.client.InventoryClient;

@Configuration
public class RestClientConfig {

	@Value("${inventory.service.base.url}")
	private String inventoryServiceBaseUrl;
	
	@Bean
	InventoryClient inventoryClient() {
		RestClient restClient = RestClient.builder()
				.baseUrl(inventoryServiceBaseUrl)
				.requestInterceptor((request, body, execution) -> {
					
					Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
					
					if(authentication != null && authentication instanceof JwtAuthenticationToken)
					{
						JwtAuthenticationToken jwtAuthToken = (JwtAuthenticationToken) authentication;
						String tokenValue = jwtAuthToken.getToken().getTokenValue();
						request.getHeaders().setBearerAuth(tokenValue);
					}
					
					return execution.execute(request, body);
				})
				.build();
		
		RestClientAdapter restClientAdapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServiceProxyFactory.createClient(InventoryClient.class);
	}
	
}
