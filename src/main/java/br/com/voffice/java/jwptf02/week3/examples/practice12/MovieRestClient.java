package br.com.voffice.java.jwptf02.week3.examples.practice12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieRestClient {

	@Autowired
	private RestTemplate builder;

	public ResponseEntity<String> getInfo() {
		return builder.getForEntity("/info", String.class);
	}

}
