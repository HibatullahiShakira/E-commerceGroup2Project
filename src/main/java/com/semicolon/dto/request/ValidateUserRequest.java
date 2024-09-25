package com.semicolon.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ValidateUserRequest {
  private String  findUserByEmailAddressAndPassword;
  private String passWord;
  private String emailAddress;
}
