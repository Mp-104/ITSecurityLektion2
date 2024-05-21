package com.example.demo.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

    @Test
    public void endPointTest () {

        TestRestTemplate testRestTemplate = new TestRestTemplate();

        ResponseEntity<String> retur = testRestTemplate.getForEntity("http://localhost:8080/", String.class);

        assertThat(retur.getStatusCode().isSameCodeAs(HttpStatus.OK));

        assertThat(retur.getBody()).isEqualTo("Welcome to my site!");
    }

}
