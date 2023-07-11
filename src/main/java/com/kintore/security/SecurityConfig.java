package com.kintore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			// ...
			.headers(headers -> headers
				.frameOptions(frameOptions -> frameOptions
					.sameOrigin()				
				)
			);
        http.csrf(csrf -> csrf.ignoringAntMatchers("/api/login"));
		return http.build();
	}
}