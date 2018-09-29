package br.com.voffice.java.jwptf02.week3.examples.practice10;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import br.com.voffice.java.jwptf02.week3.examples.practice10.MovieRestController.Movie;
import br.com.voffice.java.jwptf02.week3.examples.practice11.ApplicationProperties;

@Repository("movieRepository10")
@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@EnableConfigurationProperties(ApplicationProperties.class)
public class InMemoryMovieRepository {

	@Autowired
	private ApplicationProperties applicationProperties;

	private final Movie movie1 = Movie.builder().id(1L).title("movie 1").releasedDate(LocalDate.of(2018,1,1)).budget(0.00).build();
	private final Movie movie2 = Movie.builder().id(2L).title("movie 2").releasedDate(LocalDate.of(2017,2,1)).budget(0.00).build();
	private final Movie movie3 = Movie.builder().id(3L).title("movie 3").releasedDate(LocalDate.of(2016,3,1)).budget(0.00).build();
	private final Map<Long,Movie> movies = new HashMap<>();

	public List<Movie> findAll(){
		return new LinkedList<>(movies.values());
	}

	public void create(Movie movie) throws RuntimeException {
		movie.setId(new Random().nextLong());
		movies.put(movie.getId(),movie);
	}

	public void loadDemoList() throws Exception {
		create(movie1);
		create(movie2);
		create(movie3);
		InputStream is = new ClassPathResource(this.applicationProperties.getMovies().getDatafile()).getInputStream();
		String contents = IOUtils.toString(is,Charset.forName("UTF-8"));
		try(Scanner sc = new Scanner(contents)){
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] parts = line.split(";");
				String title = parts[0];
				String releasedDateAsString = parts[1];
				String budgetAsString = parts[2];
				LocalDate releasedDate = LocalDate.parse(releasedDateAsString);
				double budget = Double.parseDouble(budgetAsString);
				create(Movie.builder().title(title).releasedDate(releasedDate).budget(budget ).build());
			}
		}
	}

	public Optional<Movie> findById(long id) {
		return Optional.ofNullable(movies.get(id));
	}

	public void deleteById(long id) {
		movies.remove(id);
	}

	public void update(long id, Movie movie) throws Exception {
		if (!movies.containsKey(id)) throw new Exception("movie not found");
		movie.setId(id);
		movies.put(id, movie);
	}

}
