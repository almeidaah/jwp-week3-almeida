package br.com.voffice.java.jwptf02.week3.examples.practice12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfiguration {

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	@Bean
	public RestTemplate buildRestTemplate() {
		return restTemplateBuilder.build();
	}

}
