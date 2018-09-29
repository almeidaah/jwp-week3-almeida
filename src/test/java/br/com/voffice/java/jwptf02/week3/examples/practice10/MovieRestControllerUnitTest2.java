package br.com.voffice.java.jwptf02.week3.examples.practice10;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MovieRestControllerUnitTest2 {

@Autowired
private MockMvc mvc;

@Test
public void exampleTest() throws Exception {
	ResultActions resultActions = this.mvc.perform(get("/examples/movies"));
	resultActions.andExpect(status().isOk());
	resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.length()", CoreMatchers.is(8)));
}
}