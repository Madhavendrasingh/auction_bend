package org.negi.auction_backend.hepler.Auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth-> auth
                .requestMatchers("/api/users").denyAll()
                .requestMatchers(HttpMethod.DELETE,"/api/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/**").permitAll()
                .requestMatchers(HttpMethod.PUT,"/api/**").permitAll()
                .requestMatchers(HttpMethod.POST,"/api/**").permitAll()
                .anyRequest().permitAll()
        );

        return httpSecurity.build();
    }

    //@Bean
    //public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    //    return authenticationConfiguration.getAuthenticationManager();
    //}
}