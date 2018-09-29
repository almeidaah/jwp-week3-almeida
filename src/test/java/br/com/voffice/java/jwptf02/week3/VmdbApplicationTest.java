package br.com.voffice.java.jwptf02.week3;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VmdbApplicationTest {

	@Autowired
	VmdbApplication app;

	@Test
	public void load() {
		Assertions.assertThat(app).isNotNull();
	}
}
