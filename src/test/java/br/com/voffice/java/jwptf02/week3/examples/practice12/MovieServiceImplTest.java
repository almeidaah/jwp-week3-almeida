package br.com.voffice.java.jwptf02.week3.examples.practice12;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.voffice.java.jwptf02.week3.examples.practice10.InMemoryMovieRepository;
import br.com.voffice.java.jwptf02.week3.examples.practice10.MovieRestController.Movie;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
public class MovieServiceImplTest {

	@Autowired
	private MovieService movieService;

	@MockBean
	private InMemoryMovieRepository movieRepository;

	@Test
	public void findAll_happy() {
		Mockito.when(movieRepository.findAll()).thenReturn(Arrays.asList(Movie.builder().budget(1.0).build()));
		Assertions.assertThat(movieService.findAllMovies()).hasSize(1);
	}

	@Test
	public void findAll_bad() {
		Mockito.when(movieRepository.findAll()).thenReturn(null);
		Assertions.assertThat(movieService.findAllMovies()).isNull();
	}
}

