package com.user.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/h2-console/**").permitAll()
				.antMatchers(HttpMethod.POST, "/user").permitAll().antMatchers(HttpMethod.GET, "/user/**").permitAll()
				.and().headers().frameOptions().sameOrigin() // enable H2 console iframe
				.and().csrf().disable();
	}
}
