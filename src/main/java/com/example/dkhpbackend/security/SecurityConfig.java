package com.example.dkhpbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.dkhpbackend.security.jwt.JwtAuthEntryPoint;
import com.example.dkhpbackend.security.jwt.JwtAuthenticationFilter;
import com.example.dkhpbackend.service.impl.CustomUserDetails;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Value;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

     // Jwt Auth Entry Point
     private JwtAuthEntryPoint authEntryPoint;

     // Client host
     @Value("${spring.integration.rsocket.client.host}")
     private String CLIENT_HOST;

     // Constructor
     public SecurityConfig(CustomUserDetails userDetailsService, JwtAuthEntryPoint authEntryPoint) {
          // Constructor
          this.authEntryPoint = authEntryPoint;
     }

     /**
      * @param http
      * @return
      * @throws Exception
      */
     @Bean
     protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          // CORS Config
          http.cors(withDefaults());

          // Config Http Request
          http.csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(
                              (auth) -> auth.requestMatchers("/api/auth/**").permitAll().anyRequest().authenticated())
                    .exceptionHandling(handling -> handling.authenticationEntryPoint(this.authEntryPoint))
                    .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .httpBasic(basic -> basic.disable());

          // Add Filter before
          http.addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

          // Return
          return http.build();
     }

     @Bean
     public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
               throws Exception {
          // Return
          return authenticationConfiguration.getAuthenticationManager();
     }

     @Bean
     public CorsConfigurationSource corsConfigurationSource() {
          // Cors Configuration
          CorsConfiguration configuration = new CorsConfiguration();

          // Set Allow Origin *
          configuration.addAllowedOrigin(CLIENT_HOST);
          // Set Allow Method *
          configuration.addAllowedMethod("*");

          // Add Allow to header
          configuration.addAllowedHeader("*");

          configuration.setAllowCredentials(true);

          // Source
          UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

          // Register cors configuration
          source.registerCorsConfiguration("/**", configuration);

          // Return
          return source;
     }

     @Bean
     PasswordEncoder passwordEncoder() {
          // Return
          return new BCryptPasswordEncoder();
     }
}
