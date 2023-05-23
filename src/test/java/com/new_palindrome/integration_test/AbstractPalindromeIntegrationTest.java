package com.new_palindrome.integration_test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.new_palindrome.NewPalindromeApplication;
import com.new_palindrome.entity.Users;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
    classes = NewPalindromeApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractPalindromeIntegrationTest {

  @LocalServerPort private int port;

  TestRestTemplate restTemplate = new TestRestTemplate();

  HttpHeaders headers = new HttpHeaders();

  protected HttpEntity<Users> getHeader(Users users) {
    return new HttpEntity<>(users, headers);
  }

  protected String createURLWithPort(String uri) {
    return "http://localhost:" + port + uri;
  }

  protected ResponseEntity<String> getServiceResponse(Users users){
    return restTemplate.exchange(
            createURLWithPort("/validate-palindrome"), HttpMethod.POST, getHeader(users), String.class);
  }
}
