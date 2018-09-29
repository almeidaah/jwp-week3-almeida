package br.com.voffice.java.jwptf02.week3.examples.practice09;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String[] WHITELIST = { "/css/**", "/security/public", "/api/movies", "/api/movies/*",
			"/files" , "/examples/movies","/home"};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(WHITELIST).permitAll().//
				anyRequest().fullyAuthenticated().//
				and().formLogin().permitAll().//
				and().logout().permitAll();
		http.csrf().disable();
	}

}