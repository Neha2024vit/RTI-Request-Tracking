package com.example.rti;
import org.springframework.context.annotation.*; import org.springframework.security.core.userdetails.*;
@Configuration public class UserDetailsServiceConfig {
 @Bean UserDetailsService userDetailsService(AppUserRepository repo){return email->repo.findByEmailIgnoreCase(email).map(a->User.withUsername(a.getEmail()).password(a.getPassword()).roles(a.getRole()).build()).orElseThrow(()->new UsernameNotFoundException("Account not found"));}
}