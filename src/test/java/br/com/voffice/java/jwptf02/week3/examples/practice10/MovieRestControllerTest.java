package br.com.voffice.java.jwptf02.week3.examples.practice10;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.voffice.java.jwptf02.week3.examples.practice10.MovieRestController.Movie;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MovieRestControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getHome_sad_notFound() {
		@SuppressWarnings("unchecked")
		Map<String,String> response = this.restTemplate.getForObject("/home", Map.class);
		assertThat(response).containsEntry("error", "Not Found");
	}

	@Test
	public void getHome_sad_responseEntity() {
		ResponseEntity<String> response = this.restTemplate.getForEntity("/home", String.class);
		assertThat(response.getBody()).contains("error").contains("Not Found");
	}

	@Test
	public void getMovies_success() {
		@SuppressWarnings("unchecked")
		List<Movie> response = this.restTemplate.getForObject("/examples/movies", List.class);
		assertThat(response).hasSize(8);
	}

	@Test
	public void getMovies_success_responseEntity() {
		ResponseEntity<Movie[]> response = this.restTemplate.getForEntity("/examples/movies", Movie[].class);
		assertThat(response.getBody()).hasSize(8);
	}

}
