package com.semicolon.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    private String emailAddress;
    private String passWord;
    private String address;
    private String firstName;
    private String gander;
    private String phoneNumber;
    private String age;
}
