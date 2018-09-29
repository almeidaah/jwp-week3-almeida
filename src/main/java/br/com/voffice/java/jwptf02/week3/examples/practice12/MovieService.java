package br.com.voffice.java.jwptf02.week3.examples.practice12;

import java.util.List;

import br.com.voffice.java.jwptf02.week3.examples.practice10.MovieRestController.Movie;

public interface MovieService {

	List<Movie> findAllMovies();

	void saveAll(List<Movie> movie);


}
