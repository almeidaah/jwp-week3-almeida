package br.com.voffice.java.jwptf02.week3.examples.practice10;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController("movieRestController10")
@RequestMapping("/examples/movies")
public class MovieRestController {

	@Autowired InMemoryMovieRepository movieRepository;

	@PostConstruct
	public void init() throws Exception {
		movieRepository.loadDemoList();
	}

	@GetMapping
	public List<Movie> getMovies(){
		return movieRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable long id){
		  return movieRepository.findById(id)
			        .map(ResponseEntity::ok)
			        .orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public void postMovie(@RequestBody @Validated Movie movie) throws Exception {
		movieRepository.create(movie);
	}

	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable long id){
		movieRepository.deleteById(id);

	}

	@PutMapping("/{id}")
	public void putMovie(@PathVariable long id, @Validated(PutMapping.class) @RequestBody Movie movie) throws Exception {
		movieRepository.update(id, movie);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,String>> handle(Exception e){
		Map<String,String> result = new HashMap<>();
		result.put("error", e.getMessage());
		result.put("application", "vmdb");
		return ResponseEntity.badRequest().body(result);
	}

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	@JsonInclude(Include.NON_EMPTY)
	public static class Movie {
		@Exists(groups=PutMapping.class)
		private long id;
		@NotNull @Size(min=2, max=200)
		private String title;
		@PastOrPresent
		private LocalDate releasedDate;
		@Min(0)
		private double budget;
		@Min(0) @Max(100)
		private Long rating;
		private Boolean result;
	}



}

