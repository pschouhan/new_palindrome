package com.new_palindrome.service.impl;

import com.new_palindrome.controller.PalindromeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import com.new_palindrome.entity.Users;
import com.new_palindrome.repository.PalindromeRepository;
import com.new_palindrome.utils.PalindromeConstants;
import com.new_palindrome.utils.PalindromeUtilsImpl;

/**
 * This class contains a method which implements the cache mechanism that is populated from the
 * database during application startup
 */
@Component
public class PalindromeCacheImpl {

  Logger logger = LoggerFactory.getLogger(PalindromeCacheImpl.class);

  @Autowired private PalindromeRepository palindromeRepository;

  @Autowired private PalindromeUtilsImpl palindromeUtilsImpl;

  /**
   * This method first checks the palindrome present in cache memory if not present then first do
   * check for the Alphabetic and Palindrome then save in database returns a text string value
   *
   * @param users
   * @param value
   * @return text String if value is a palindrome, or not, or invalid
   */
  @Cacheable(cacheNames = "usersCache", key = "#value")
  public String getPalindrome(Users users, String value) {
    String result;
    Users obj = palindromeRepository.findUserByValue(value);
    if (obj != null) {
      logger.info("Fetching value from the database");
      result = PalindromeConstants.VALID_MESSAGE;
    } else {
      if (palindromeUtilsImpl.isAlpha(users.getValue())) {
        if (palindromeUtilsImpl.isPalindrome(users.getValue())) {
          logger.info(users.getValue() + " : new Palindrome value is saved in the database");
          palindromeRepository.save(users);
          result = PalindromeConstants.VALID_MESSAGE;
        } else {
          result = PalindromeConstants.INVALID_MESSAGE;
        }
      } else {
        result = PalindromeConstants.INVALID_ALPHA_MESSAGE;
      }
    }
    return result;
  }
}
