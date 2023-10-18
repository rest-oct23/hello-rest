package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTests {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class))
                .contains("Ola ke ase");
    }

    @Test
    public void canAdd() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/add?a=1&b=2", String.class))
                .isEqualTo("3.0");
    }

    @Test
    public void canAddA() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/add?a=1", String.class))
                .isEqualTo("1.0");
    }

    @Test
    public void canAddB() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/add?b=2", String.class))
                .isEqualTo("2.0");
    }


}