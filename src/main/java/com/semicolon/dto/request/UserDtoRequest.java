package com.semicolon.dto.request;

import com.semicolon.data.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoRequest {
    private String emailAddress;
    private String password;
    private String address;
    private String firstName;
    private UserRole userRole;
    private String age;
    private String gender;
    private String phoneNumber;

}
