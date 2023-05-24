package com.new_palindrome.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * This entity class contains variables, constructors and methods for populate the users object and mapped with database table columns
 */
@Entity
@Table(name = "my_user")
public class Users {

  Users() {}

  public Users(Long id, String userName, String value) {
    super();
    this.id = id;
    this.userName = userName;
    this.value = value;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "user_name")
  @NotBlank(message = "User Name is required")
  private String userName;

  @NotBlank(message = "User Value is required")
  @Pattern(regexp = "^[a-zA-Z]*$", message = "User Value is invalid")
  @Column(name = "user_value")
  private String value;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
