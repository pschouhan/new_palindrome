package com.new_palindrome.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PalindromeUtilsImplTest {

  @Autowired private PalindromeUtilsImpl validation;

  @Test
  void testPalindrome() {
    assertEquals(true, validation.isPalindrome("MADAM"));
  }

  @Test
  void testNonPalindrome() {
    assertEquals(false, validation.isPalindrome("MADAMA"));
  }

  @Test
  void testAlpha() {
    assertEquals(true, validation.isAlpha("Prabhudev"));
  }

  @Test
  void testNonAlpha() {
    assertEquals(false, validation.isAlpha("Prabhudev123"));
  }
}
