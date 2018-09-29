package br.com.voffice.java.jwptf02.week3.application.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.voffice.java.jwptf02.week3.application.entities.Movie;

@Repository
public class InMemoryMovieRepository implements MovieRepository {

	private final Map<Long, Movie> database = new HashMap<>();

	@Override
	public Collection<Movie> findAll() {
		return database.values();
	}

	@Override
	public Long create(Movie movie) {
		long id = System.currentTimeMillis();
		movie.setId(id);
		database.put(id, movie);
		return id;
	}

	@Override
	public Movie findById(Long id) {
		return database.get(id);
	}

	@Override
	public void update(Movie movie) {
		database.put(movie.getId(), movie);
	}

	@Override
	public void remove(Long id) {
		if (database.containsKey(id)) {
			database.remove(id);
		} else {
			throw new IllegalArgumentException("movie with id "+id+" not found");
		}
	}

	@Override
	public boolean contains(Long id) {
		return findById(id) != null;
	}

}
