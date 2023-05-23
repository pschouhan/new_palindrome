package com.new_palindrome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.annotation.Validated;

import com.new_palindrome.controller.PalindromeController;

@SpringBootApplication
@ComponentScan(basePackageClasses = PalindromeController.class)
@ComponentScan("com.new_palindrome")
@EnableCaching
@Validated
public class NewPalindromeApplication {

  public static void main(String[] args) {
    SpringApplication.run(NewPalindromeApplication.class, args);
  }
}
