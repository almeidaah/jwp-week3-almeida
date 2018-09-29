package br.com.voffice.java.jwptf02.week3.examples.practice10;

import java.io.IOException;
import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.voffice.java.jwptf02.week3.examples.practice10.MovieRestController.Movie;

@RunWith(SpringRunner.class)
@JsonTest
public class MovieTest {

	@Autowired
	JacksonTester<Movie> json;

	Movie asMovie = Movie.builder().title("avengers").releasedDate(LocalDate.of(2018,4,25)).build();
	String asJson = "{\"id\":0,\"title\":\"avengers\",\"releasedDate\":\"2018-04-25\",\"budget\":0.0}";

	@Test
	public void write() throws IOException {
		String contents = json.write(asMovie).getJson();
		Assertions.assertThat(contents).isEqualTo(asJson);
	}

	@Test
	public void read() throws IOException {
		Movie contents = json.parseObject(asJson);
		Assertions.assertThat(contents).isEqualTo(asMovie);
	}

}

