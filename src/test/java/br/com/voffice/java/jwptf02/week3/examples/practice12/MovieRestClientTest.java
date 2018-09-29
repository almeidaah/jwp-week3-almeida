package br.com.voffice.java.jwptf02.week3.examples.practice12;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

@RunWith(SpringRunner.class)
@RestClientTest(MovieRestClient.class)
@AutoConfigureWebClient(registerRestTemplate=true)
public class MovieRestClientTest {

	@Autowired
	private MovieRestClient service;

	@Autowired
	private MockRestServiceServer server;

	@Test
	public void getVehicleDetailsWhenResultIsSuccessShouldReturnDetails()
			throws Exception {
		String expectedBody = "y";
		this.server.expect(requestTo("/info"))
				.andRespond(withSuccess(expectedBody, MediaType.APPLICATION_JSON));
		ResponseEntity<String> responseEntity = this.service.getInfo();
		Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(responseEntity.getBody()).isEqualTo(expectedBody);
	}

}
