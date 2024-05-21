package com.example.demo.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@TestPropertySource(properties = { "spring.security.user.name=user", "spring.security.user.password=secret" } )
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

    @Test
    public void endPointTest () {

        TestRestTemplate testRestTemplate = new TestRestTemplate()/*.withBasicAuth("user", "4edcc4e7-be67-4220-8749-8b4ed65b46fc")*/;

        ResponseEntity<String> retur = testRestTemplate.withBasicAuth("user", "4edcc4e7-be67-4220-8749-8b4ed65b46fc").getForEntity("http://localhost:8080/", String.class);


        assertThat(retur.getStatusCode().isSameCodeAs(HttpStatus.OK));

        assertThat(retur.getBody()).isEqualTo("Welcome to my site!");
    }

}
