package com.Suresh.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Autowired private PasswordEncoder bcryptPasswordEncoder;
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("suresh").password("{bcrypt}$2a$10$zmC9wlhILVTGPUoZQxSQR.2kQkKz5520GCqGSmkUyTabmMvdrRj0u").roles("ADMIN").and() //suresh123
		.withUser("suri").password("$2a$10$BVM1iwznW03IPraDhYqeguxO2KTi6ISM0nerq8LrGFR1qQbXE6MA6").roles("USER");   //suri123
		
		//System.out.println("bycrptPassword for suri123 user password " +bcryptPasswordEncoder.encode("suri123"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/loan").authenticated()
		.antMatchers("/statement").authenticated()
		.antMatchers("/balance").authenticated()
		.antMatchers("/").permitAll()
		.antMatchers("/contact").permitAll()
		.and()
		.formLogin()
		.and()  
        .httpBasic();
	}

	
	
}
