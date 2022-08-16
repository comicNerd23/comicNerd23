package com.moulik.bookkeeper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.moulik.bookkeeper.filter.JwtAuthenticationFilter;
import com.moulik.bookkeeper.filter.JwtAuthorizationFilter;
import com.moulik.bookkeeper.util.SecurityConstants;

/**
 * 
 *
 */
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	private UserDetailsService userDetailsService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public WebSecurity(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	/**
	 * Authorization needs to be configured here using configure(HttpSecurity)
	 * Here we specify the secure endpoints and filters that we want to apply. We configure CORS, and then we 
	 * permit all post requests to our sign up URL that we defined in the constants class.
	 *
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * Start with most-restrictive from the top and go down with least restrictive at the bottom
		 */
		 http.cors()
		 .and().authorizeRequests().antMatchers("/h2-console/**").permitAll() //Added for H2
		 .and().authorizeRequests()
         .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
         .anyRequest().authenticated()
         .and()
         .addFilter(new JwtAuthenticationFilter(authenticationManager()))
         .addFilter(new JwtAuthorizationFilter(authenticationManager()))
         // this disables session creation on Spring Security
         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and().csrf().disable();
		 
		 http.headers().frameOptions().disable();
	}
	
	
	/**
	 * Authentication needs to be configured here using configure(AuthenticationManagerBuilder)
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//configures the AuthenticationManager to use our encoder object as its password encoder while checking the 
		//credentials
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
		
		/*
		 * auth.inMemoryAuthentication() .withUser("user1") .password("pass1")
		 * .roles("USER")
		 * .and().withUser("user2").password("pass2").roles("ADMIN");
		 */
	}
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return source;
    }
	
	

}
