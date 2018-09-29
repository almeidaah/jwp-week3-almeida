package br.com.voffice.java.jwptf02.week3.examples.practice09;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AuthenticationSecurity {

	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return new InMemoryUserDetailsManager(
				User.withUsername("demo1").password(encoder.encode("1"))
						.roles("ADMIN", "USER", "ACTUATOR").build(),
				User.withUsername("demo2").password(encoder.encode("2"))
						.roles("USER").build());
	}
}
