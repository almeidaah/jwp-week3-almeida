package br.com.voffice.java.jwptf02.week3.examples.practice10;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsConstraintValidator implements ConstraintValidator<Exists,Long> {

	@Autowired
	private InMemoryMovieRepository movieRepository;

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		return movieRepository.findById(value).isPresent();
	}

}
