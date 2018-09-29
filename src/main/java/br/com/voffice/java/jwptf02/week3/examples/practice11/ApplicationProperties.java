package br.com.voffice.java.jwptf02.week3.examples.practice11;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="application")
public class ApplicationProperties {

	private Movies movies;

	@Data
	public static class Movies {
		private String datafile;
	}

}
