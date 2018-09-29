package br.com.voffice.java.jwptf02.week3.examples.practice11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import br.com.voffice.java.jwptf02.week3.examples.practice10.InMemoryMovieRepository;

@Component
public class MoviesCounterInfoContributor implements InfoContributor, HealthIndicator {

	private Logger log = LoggerFactory.getLogger(MoviesCounterInfoContributor.class);

	@Autowired
	InMemoryMovieRepository movies;

	@Override
	public void contribute(Builder builder) {
		try {
			movies.loadDemoList();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
		}
		builder.withDetail("counter", movies.findAll().size());
	}

	@Override
	public Health health() {
		return Health.status("very good").build();
	}

}
