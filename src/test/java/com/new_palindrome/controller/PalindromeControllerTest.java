package com.new_palindrome.controller;

import static com.new_palindrome.utils.PalindromeConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.new_palindrome.integration_test.PalindromeGetIntegrationTest;
import com.new_palindrome.service.impl.PalindromeCacheImpl;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import com.new_palindrome.entity.Users;
import com.new_palindrome.service.impl.PalindromeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class PalindromeControllerTest {

  Logger logger = LoggerFactory.getLogger(PalindromeControllerTest.class);

  @Autowired private PalindromeController palindromeController;
  @MockBean PalindromeServiceImpl palindromeServiceImpl;
  @MockBean PalindromeCacheImpl palindromeCacheImpl;

  String expected = "";

  /** This test is used to validate palindrome value */
  @Test
  public void testValidatePalindromeValue() {
    Users users = new Users((long) 2, "abcd", "MDSDM");

    Mockito.when(palindromeCacheImpl.getPalindrome(users, users.getValue()))
        .thenReturn(VALID_MESSAGE);
    Mockito.when(palindromeServiceImpl.validate(users)).thenReturn(expected);

    String actual = palindromeController.validatePalindrome(users);
    logger.info("Actual Result : " + actual);
    assertEquals(expected, actual);
  }

  /** This test is used to validate the non palindrome value */
  @Test
  public void testValidateNonPalindromeValue() {
    Users users = new Users((long) 2, "abcdc", "kanakst");

    Mockito.when(palindromeCacheImpl.getPalindrome(users, users.getValue()))
        .thenReturn(INVALID_MESSAGE);
    Mockito.when(palindromeServiceImpl.validate(users)).thenReturn(expected);

    String actual = palindromeController.validatePalindrome(users);
    logger.info("Actual Result : " + actual);
    assertEquals(expected, actual);
  }

  /** This test is used to validate the non-alphabetic value */
  @Test
  public void testValidateNonAlphabeticValue() {
    Users users = new Users((long) 2, "abcdc", "kanak34st");

    Mockito.when(palindromeCacheImpl.getPalindrome(users, users.getValue()))
        .thenReturn(INVALID_ALPHA_MESSAGE);
    Mockito.when(palindromeServiceImpl.validate(users)).thenReturn(expected);

    String actual = palindromeController.validatePalindrome(users);
    logger.info("Actual Result : " + actual);
    assertEquals(expected, actual);
  }

  /** This test is used to validate the invalid value */
  @Test
  public void testValidateInvalidValue() {
    Users users = new Users((long) 2, "abcdc", "kanak st");

    Mockito.when(palindromeCacheImpl.getPalindrome(users, users.getValue()))
        .thenReturn(INVALID_ALPHA_MESSAGE);
    Mockito.when(palindromeServiceImpl.validate(users)).thenReturn(expected);

    String actual = palindromeController.validatePalindrome(users);
    logger.info("Actual Result : " + actual);
    assertEquals(expected, actual);
  }
}
