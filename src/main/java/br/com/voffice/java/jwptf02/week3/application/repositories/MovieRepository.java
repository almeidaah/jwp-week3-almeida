package br.com.voffice.java.jwptf02.week3.application.repositories;

import java.util.Collection;

import br.com.voffice.java.jwptf02.week3.application.entities.Movie;

public interface MovieRepository {

	Collection<Movie> findAll();

	Long create(Movie movie);

	Movie findById(Long id);

	void update(Movie movie);

	void remove(Long id);

	boolean contains(Long id);

}
