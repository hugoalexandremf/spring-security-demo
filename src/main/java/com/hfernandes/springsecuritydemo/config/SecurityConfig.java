package com.hfernandes.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        *//*http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/auth/**").permitAll();*//*

         http
                 .csrf().disable()
                 .authorizeHttpRequests((authz) -> authz
                         .requestMatchers("/auth/**").permitAll()
                         .anyRequest().authenticated()
                 );

        return http.build();
    }*/

     /*@Bean
     public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
          http
                  .csrf().disable()
                  .authorizeHttpRequests((authz) -> authz
                          .requestMatchers("/auth/**").permitAll()
                          .anyRequest().authenticated()
                  );

          return http.build();
     }*/

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
          return http
                  .csrf().disable()
                  .authorizeHttpRequests((authz) -> authz
                          .requestMatchers("/auth/**").permitAll()
                          .anyRequest().authenticated()
                  )
                  .sessionManagement()
                  .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                  .and()
                  .build();
     }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }
}