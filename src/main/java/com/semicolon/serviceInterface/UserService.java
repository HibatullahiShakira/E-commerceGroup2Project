package com.semicolon.serviceInterface;


import com.semicolon.data.model.User;
import com.semicolon.dto.request.UserDtoRequest;
import com.semicolon.dto.request.UserUpdateRequest;
import com.semicolon.dto.request.ValidateUserRequest;
import com.semicolon.dto.response.AddUserResponse;
import com.semicolon.dto.response.UserDtoResponse;
import com.semicolon.dto.response.UserUpdateResponse;

import java.util.List;

public interface UserService {
    List<User> getAllUser(ValidateUserRequest validateUserRequest);
    AddUserResponse addUser(UserDtoRequest userDtoRequest);
    UserUpdateResponse updateUser(UserUpdateRequest userUpdateRequest);
    String removeUser(ValidateUserRequest validateUserRequest);
    UserDtoResponse getUserDto(ValidateUserRequest validateUserRequest);

}