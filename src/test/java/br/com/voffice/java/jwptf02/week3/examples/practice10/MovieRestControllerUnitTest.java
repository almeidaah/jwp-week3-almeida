package br.com.voffice.java.jwptf02.week3.examples.practice10;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=MovieRestController.class, secure=false)
public class MovieRestControllerUnitTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private InMemoryMovieRepository movieRepository;

	@Test
	public void getMovies() throws Exception {
		this.mvc.perform(get("/examples/movies").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.length()", CoreMatchers.is(0)));
	}

	@Test
	public void putMovies() throws Exception {
		this.mvc.perform(put("/examples/movies/1").content("{}").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

}