package com.vitoria.security;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vitoria.services.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	final UserDetailsServiceImpl userDetailsService;
	
	public WebSecurityConfig (UserDetailsServiceImpl userDetailsService) {
		this.userDetailsService=userDetailsService;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic()
		.and()
		.authorizeHttpRequests()
		.antMatchers(HttpMethod.GET, "/flowers", "/flowers/**").permitAll()
		.antMatchers(HttpMethod.POST, "/flowers/**").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.DELETE, "/flowers/**").hasRole("ADMIN")
		.antMatchers("/users","/users/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.csrf()
		.disable();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder());  
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
