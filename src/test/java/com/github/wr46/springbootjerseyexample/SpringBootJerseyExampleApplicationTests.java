package com.github.wr46.springbootjerseyexample;

import com.github.wr46.springbootjerseyexample.entities.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootJerseyExampleApplicationTests {

	private static final String BASE_API_URL = "/api/tasks";

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void whenGetAllTaskThenReturnSuccess() {
		ResponseEntity<Task[]> entity = this.restTemplate.getForEntity(BASE_API_URL, Task[].class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void whenPostTaskThenReturnSuccess() {
		Task task = new Task();
		task.setName("Test");
		ResponseEntity<Task> entity = this.restTemplate.postForEntity(BASE_API_URL, task, Task.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
