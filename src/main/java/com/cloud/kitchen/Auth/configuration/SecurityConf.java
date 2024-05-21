package com.cloud.kitchen.Auth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration  
// @EnableWebSecurity
public class SecurityConf{

    
    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      
    //     http.csrf().disable()
    //     .authorizeHttpRequests(authorize -> authorize
    //             .requestMatchers("/api/v1/auth/**").permitAll()
    //             .anyRequest().authenticated()
    //         )
    //         .httpBasic(Customizer.withDefaults())
    //         .formLogin(Customizer.withDefaults());
    //     return http.build();
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
