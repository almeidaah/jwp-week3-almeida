package br.com.voffice.java.jwptf02.week3.examples.practice12;

import br.com.voffice.java.jwptf02.week3.examples.practice10.InMemoryMovieRepository;
import br.com.voffice.java.jwptf02.week3.examples.practice10.MovieRestController;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTest {

    @Autowired
    MovieService movieService;

    @Before
    public  void setupListMovies(){
        MovieRestController.Movie m1 = MovieRestController.Movie.builder().title("Filme1").build();
        MovieRestController.Movie m2 = MovieRestController.Movie.builder().title("Filme2").build();
        MovieRestController.Movie m3 = MovieRestController.Movie.builder().title("Filme3").build();
        movieService.saveAll(Arrays.asList(m1, m2, m3));
    }

    @Test
    public void shouldGetAllMovies(){

        List<MovieRestController.Movie> allMovies = this.movieService.findAllMovies();

        Assertions.assertThat(allMovies).isNotNull();
        assertEquals(3, allMovies.size());
    }


}
