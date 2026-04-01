package com.libms.product_service.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
				.cors(cors -> cors.configurationSource(getCorsConfigurationSource()))
				.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
				.build();
	}
	
	@Bean
	CorsConfigurationSource getCorsConfigurationSource()
	{
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.applyPermitDefaultValues();
		configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "UPDATE", "PATCH", "OPTIONS", "HEAD"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		
		return source;
	}
}
