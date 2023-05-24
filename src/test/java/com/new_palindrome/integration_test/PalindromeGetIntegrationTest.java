package com.new_palindrome.integration_test;

import com.new_palindrome.entity.Users;
import com.new_palindrome.service.impl.PalindromeCacheImpl;
import com.new_palindrome.utils.PalindromeConstants;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/** Integration tests are used to test the service endpoint with positive and negative scenarios. */
public class PalindromeGetIntegrationTest extends AbstractPalindromeIntegrationTest {

  Logger logger = LoggerFactory.getLogger(PalindromeGetIntegrationTest.class);

  /**
   * Positive Scenario - Validate service response when provide the palindrome value in the request
   * parameter
   */
  @Test
  public void shouldReturnResponseWhenProvideValidPalindromeValue() {
    Users users = new Users((long) 2, "Spring", "MAMAMAM");

    ResponseEntity<String> response = getServiceResponse(users);

    logger.info("Service response : " + response.getBody());
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(PalindromeConstants.VALID_MESSAGE, response.getBody());
  }

  /**
   * Positive Scenario - Validate service response when provide the non palindrome value in the
   * request parameter
   */
  @Test
  public void shouldReturnResponseWhenProvideNonPalindromeValue() {
    Users users = new Users((long) 1, "Spring", "Steps");

    ResponseEntity<String> response = getServiceResponse(users);

    logger.info("Service response : " + response.getBody());
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(PalindromeConstants.INVALID_MESSAGE, response.getBody());
  }
  /**
   * Negative Scenario - Validate service error response when providing the non-alphabetic value in
   * the request
   */
  @Test
  public void shouldReturnErrorResponseWhenProvideNonAlphabeticValue() {
    Users users = new Users((long) 1, "test_user", "Steps123");

    ResponseEntity<String> response = getServiceResponse(users);

    logger.info("Service response : " + response.getBody());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertNotNull(response.getBody());
  }

  /**
   * Negative Scenario - Validate service error response when providing the invalid value in the
   * request
   */
  @Test
  public void shouldReturnErrorResponseWhenProvideInvalidValue() {
    Users users = new Users((long) 1, "username", "invalid value");

    ResponseEntity<String> response = getServiceResponse(users);

    logger.info("Service response : " + response.getBody());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertNotNull(response.getBody());
  }

  /**
   * Negative Scenario - Validate service error response when providing the empty username in the
   * request
   */
  @Test
  public void shouldReturnErrorResponseWhenProvideEmptyUserName() {
    Users users = new Users((long) 1, "", "MADAM");

    ResponseEntity<String> response = getServiceResponse(users);

    logger.info("Service response : " + response.getBody());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertNotNull(response.getBody());
  }
}
