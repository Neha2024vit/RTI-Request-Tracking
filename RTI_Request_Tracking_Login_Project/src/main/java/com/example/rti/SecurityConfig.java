package com.example.rti;
import org.springframework.context.annotation.*; import org.springframework.http.HttpMethod; import org.springframework.security.config.annotation.web.builders.HttpSecurity; import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
@Configuration public class SecurityConfig {
	@Bean
	public AuthenticationManager authenticationManager(
	        AuthenticationConfiguration configuration) throws Exception {
	    return configuration.getAuthenticationManager();
	}
	@Bean
	public SecurityContextRepository securityContextRepository() {
	    return new HttpSessionSecurityContextRepository();
	}
 @Bean SecurityFilterChain filter(HttpSecurity http)throws Exception{
 http.csrf(c->c.disable()).authorizeHttpRequests(a->a
 .requestMatchers("/","/index.html","/login.html","/citizen.html","/officer.html","/*.css","/*.js").permitAll()
 .requestMatchers("/api/auth/register","/api/auth/login").permitAll()
 .requestMatchers(HttpMethod.POST,"/api/rti").hasRole("CITIZEN")
 .requestMatchers("/api/rti/summary").hasRole("OFFICER")
 .requestMatchers(HttpMethod.PUT,"/api/rti/**").hasRole("OFFICER")
 .requestMatchers(HttpMethod.GET,"/api/rti").hasAnyRole("CITIZEN","OFFICER")
 .requestMatchers("/api/rti/**","/api/auth/me").authenticated().anyRequest().authenticated())
 .logout(l->l.logoutUrl("/api/auth/logout").logoutSuccessHandler((q,s,au)->{s.setStatus(200);s.setContentType("application/json");s.getWriter().write("{\"message\":\"Logged out\"}");}));
 return http.build();
 
 }}