package com.crudapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.crudapplication.service.UserService;

@Configuration
public class SecurityConfiguration {
	

	@Autowired
	private UserService userService;
	
	 @Bean
	    public static PasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	        http.csrf().disable()
	                .authorizeHttpRequests((authorize) -> {
	                    authorize.anyRequest().authenticated();
	                }).httpBasic(Customizer.withDefaults());
	        return http.build();
	    }

	    @Bean
	    public UserDetailsService userDetailsService(){

	        UserDetails ramesh = User.builder()
	                .username("ramesh")
	                .password(passwordEncoder().encode("password"))
	                .roles("USER")
	                .build();

	        UserDetails admin = User.builder()
	                .username("admin")
	                .password(passwordEncoder().encode("admin"))
	                .roles("ADMIN")
	                .build();

	        return new InMemoryUserDetailsManager(ramesh, admin);
	    }
	
	
	
}
