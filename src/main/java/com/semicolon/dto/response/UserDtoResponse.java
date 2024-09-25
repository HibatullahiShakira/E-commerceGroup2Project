package com.semicolon.dto.response;

import com.semicolon.data.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoResponse {
    private String address;
    private String firstName;
    private String passWord;
    private UserRole userRole;
    private String age;
    private String gender;
    private String phoneNumber;
    private String emailAddress;
}
