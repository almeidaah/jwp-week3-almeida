package br.com.voffice.java.jwptf02.week3.examples.practice12;

import br.com.voffice.java.jwptf02.week3.examples.practice10.InMemoryMovieRepository;
import br.com.voffice.java.jwptf02.week3.examples.practice10.MovieRestController.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private InMemoryMovieRepository movieRepository;


	public List<Movie> findAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public void saveAll(List<Movie> movie) {
		movie.forEach(movieRepository::create);
	}

}
