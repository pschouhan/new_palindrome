package com.new_palindrome.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.new_palindrome.entity.Users;
import com.new_palindrome.service.impl.PalindromeServiceImpl;

/**
 * This controller class contains a method for handling web requests and return the response from
 * the service
 */
@RestController
@Validated
public class PalindromeController {

  @Autowired private PalindromeServiceImpl palindromeServiceImpl;

  /**
   * This method receives a request from API and return whether the value is palindrome or not, and
   * returns a text string value
   *
   * @param users
   * @return String if value is a palindrome, or not
   */
  @PostMapping("/validate-palindrome")
  public String validatePalindrome(@Valid @RequestBody Users users) {

    return palindromeServiceImpl.validate(users);
  }
}
