package com.new_palindrome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.new_palindrome.entity.Users;

public interface PalindromeRepository extends JpaRepository<Users, Long> {

  /**
   * This is a customized query to fetch the data by value
   *
   * @param value
   * @return Users
   */
  @Query(value = "SELECT * FROM my_user WHERE user_value= ?1", nativeQuery = true)
  Users findUserByValue(String value);
}
