package com.new_palindrome.service.impl;

import com.new_palindrome.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.new_palindrome.entity.Users;

/** This service class contains a method for validating the user value and return the response */
@Service
public class PalindromeServiceImpl implements PalindromeService {

  @Autowired private PalindromeCacheImpl palindromeCacheImpl;

  /**
   * This method is used to validate user value from the cache memory if not present then check for
   * the Alphabetic and Palindrome then save in the database by the getPalindrome method and returns
   * a text message
   *
   * @param users
   * @return text String if value is a palindrome, or not, or invalid
   */
  @Override
  public String validate(Users users) {
    return palindromeCacheImpl.getPalindrome(users, users.getValue());
  }
}
