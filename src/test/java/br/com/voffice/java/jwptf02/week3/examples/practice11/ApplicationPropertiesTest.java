package br.com.voffice.java.jwptf02.week3.examples.practice11;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.voffice.java.jwptf02.week3.examples.practice10.InMemoryMovieRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=InMemoryMovieRepository.class)
public class ApplicationPropertiesTest {

	@Autowired
	ApplicationProperties applicationProperties;

	@Test
	public void test() {
		Assertions.assertThat(applicationProperties.getMovies().getDatafile()).isNotEmpty();
	}

}