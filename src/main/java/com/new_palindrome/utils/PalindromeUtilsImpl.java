package com.new_palindrome.utils;

import org.springframework.stereotype.Component;

/** This class implements utility methods for checking Palindrome and alphabetic values */
@Component
public class PalindromeUtilsImpl implements PalindromeUtils {

  /**
   * This method checks whether the value is palindrome or not, and returns a boolean value
   *
   * @param value
   * @return true if value is a palindrome, or false otherwise
   */
  @Override
  public boolean isPalindrome(String value) {

    String reverse = new StringBuilder(value).reverse().toString();
    if (value.equals(reverse)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method checks whether the value is alphabet or not, and returns a boolean value
   *
   * @param s
   * @return true if value is not alphabetic, or false otherwise
   */
  @Override
  public boolean isAlpha(String s) {
    return s != null && s.matches("^[a-zA-Z]*$");
  }
}
