//package com.ilyafrolov.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends AbstractSecurityWebApplicationInitializer {
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("user")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("ADMIN", "USER")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//
//    public SecurityFilterChain createChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests()
//                .requestMatchers(HttpMethod.POST, "/user")
//                .hasRole("ADMIN")
////                .anyRequest()
////                .authenticated()
//                .and()
//                .httpBasic();
//
//        return httpSecurity.build();
//    }
//}
