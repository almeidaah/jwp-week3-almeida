package br.com.voffice.java.jwptf02.week3.examples.practice12;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class RestClientConfigurationTest {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate getRestTemplateBuilder() {
        RestTemplate build = restTemplateBuilder.build();
        Assertions.assertThat(build).isNotNull();
        return build;
    }
}
