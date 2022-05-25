package com.example.fruver.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurity extends WebSecurityConfigurerAdapter {
	private UserDetailsService userDetailsService;
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    /*
	     * 1. Se desactiva el uso de cookies
	     * 2. Se activa la configuración CORS con los valores por defecto
	     * 3. Se desactiva el filtro CSRF
	     * 4. Se indica que el login no requiere autenticación
	     * 5. Se indica que el resto de URLs esten securizadas
	     */
	    http
	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	        .cors().and()
	        .headers().frameOptions().disable().and()
	        .csrf().disable()
	        .authorizeRequests().antMatchers("/api/crearCliente", "/h2/**")
	        .permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .addFilter(new JWTAuthenticationFilter(authenticationManager()))
	        .addFilter(new JWTAuthorizationFilter(authenticationManager()));
	  }
	  
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService);
	  }
}
