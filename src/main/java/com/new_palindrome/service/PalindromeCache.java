package com.new_palindrome.service;

import com.new_palindrome.entity.Users;

public interface PalindromeCache {
  public Users getPalindrome(String value);
}
