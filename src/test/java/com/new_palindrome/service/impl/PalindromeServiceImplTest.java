package com.new_palindrome.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.new_palindrome.entity.Users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class PalindromeServiceImplTest {

  Logger logger = LoggerFactory.getLogger(PalindromeServiceImplTest.class);

  @Autowired private PalindromeServiceImpl palindromeServiceImpl;

  @MockBean private PalindromeCacheImpl palindromeCacheImpl;

  String expected = "";

  @Test
  public void testValidatePalindromeValue() {

    Users users = new Users((long) 2, "abcd", "KANAKAK");

    Mockito.when(palindromeServiceImpl.validate(users)).thenReturn(expected);

    String actual = palindromeServiceImpl.validate(users);
    logger.info("Actual Result : " + actual);
    assertEquals(expected, actual);
  }

  @Test
  public void testValidateNonPalindromeValue() {
    Users users = new Users((long) 2, "abcdc", "kanakst");

    Mockito.when(palindromeServiceImpl.validate(users)).thenReturn(expected);

    String actual = palindromeServiceImpl.validate(users);
    logger.info("Actual Result : " + actual);
    assertEquals(expected, actual);
  }

  @Test
  public void testValidateNonAlphabeticValue() {
    Users users = new Users((long) 2, "abcdc", "kanak34st");

    Mockito.when(palindromeServiceImpl.validate(users)).thenReturn(expected);

    String actual = palindromeServiceImpl.validate(users);
    logger.info("Actual Result : " + actual);
    assertEquals(expected, actual);
  }

  @Test
  public void testValidateInvalidValue() {
    Users users = new Users((long) 2, "abcdc", "kanak st");

    Mockito.when(palindromeServiceImpl.validate(users)).thenReturn(expected);

    String actual = palindromeServiceImpl.validate(users);
    logger.info("Actual Result : " + actual);
    assertEquals(expected, actual);
  }
}
