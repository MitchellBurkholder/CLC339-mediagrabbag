package com.grabbag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
		
	@Autowired
	UserBusinessService service;
		
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		        http
		            .csrf(csrf -> csrf.disable())
		            // Configure authorization rules
		            .authorizeHttpRequests(authorize -> authorize
		                .requestMatchers("/", "/images/**").permitAll()
		                .anyRequest().authenticated()
		            )
		            .httpBasic(basic -> basic.realmName("Service API"))
		            // Configure login form
		            .formLogin(form -> form
		                .loginPage("/login")
		                .usernameParameter("username")
		                .passwordParameter("password")
		                .permitAll()
		                .defaultSuccessUrl("/orders/display", true)
		            )
		            // Configure logout
		            .logout(logout -> logout
		                .logoutUrl("/logout")
		                .invalidateHttpSession(true)
		                .clearAuthentication(true)
		                .permitAll()
		                .logoutSuccessUrl("/")
		            );

		        return http.build();
		    }
		  
		  @SuppressWarnings("deprecation")
		  @Bean
			public PasswordEncoder passwordEncoder() {
			    return NoOpPasswordEncoder.getInstance();
			}
		  
		  @Bean
			public AuthenticationProvider authenticationProvider() {
			    DaoAuthenticationProvider provider = new DaoAuthenticationProvider(service);
			    provider.setPasswordEncoder(passwordEncoder());
			    return provider;
			}

		    @Bean
			public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
				return config.getAuthenticationManager();
			}

			@Bean
			public UserDetailsService userDetailsService() {
				return service; 
			}
}
