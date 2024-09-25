package com.semicolon.serviceImpl;

import com.semicolon.data.model.CreditCard;
import com.semicolon.data.model.User;
import com.semicolon.data.repositories.UserRepository;
import com.semicolon.dto.request.UserDtoRequest;
import com.semicolon.dto.request.UserUpdateRequest;
import com.semicolon.dto.request.ValidateUserRequest;
import com.semicolon.dto.response.AddUserResponse;
import com.semicolon.dto.response.UserDtoResponse;
import com.semicolon.dto.response.UserUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements com.semicolon.serviceInterface.UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser(ValidateUserRequest validateUserRequest) {
        userRepository.findUserByEmailAddressAndPassword(validateUserRequest.getFindUserByEmailAddressAndPassword(), validateUserRequest.getPassWord());
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public AddUserResponse addUser(UserDtoRequest userDtoRequest) {
        AddUserResponse addUserResponse = new AddUserResponse();
        try {
            String email = userDtoRequest.getEmailAddress().trim().toLowerCase();
            String password = userDtoRequest.getPassword();
            if (email.isEmpty() || password.isEmpty() || password.equals(" ")) {
                addUserResponse.setMessage("Email or password address cannot be empty");
                return addUserResponse;
            }
            if (password.length() > 6) {
                addUserResponse.setMessage("Password must be at least 6 characters");
            }
            if (!email.contains("@") && !email.contains(".")) {
                addUserResponse.setMessage("Email address is not a valid email address");
                return addUserResponse;
            }
            if (userRepository.existsUserByEmailAddress(userDtoRequest.getEmailAddress())) {
                addUserResponse.setMessage("Email address already exists");
            }

            User user = new User();
            user.setAddress(userDtoRequest.getAddress());
            user.setFirstName(userDtoRequest.getFirstName());
            user.setPassword(userDtoRequest.getPassword());
            user.setUserRole(userDtoRequest.getUserRole());
            user.setAge(userDtoRequest.getAge());
            user.setGender(userDtoRequest.getGender());
            user.setPhoneNumber(userDtoRequest.getPhoneNumber());
            user.setEmailAddress(userDtoRequest.getEmailAddress());
            userRepository.save(user);
            addUserResponse.setUserId(user.getUserId());
            addUserResponse.setMessage("Successfully added user");
        } catch (Exception e) {
            addUserResponse.setMessage("Error adding user");
        }

        return addUserResponse;
    }

    @Override
    public UserUpdateResponse updateUser(UserUpdateRequest userUpdateRequest) {
        UserUpdateResponse userUpdateResponse = new UserUpdateResponse();
        try {
            User foundUser = userRepository.findUserByEmailAddressAndPassword(userUpdateRequest.getEmailAddress(), userUpdateRequest.getPassWord());
            if (foundUser == null) {
                throw new NullPointerException("User not found");
            }
            if (userUpdateRequest.getEmailAddress() != null && userUpdateRequest.getEmailAddress().equals(foundUser.getEmailAddress())) {
                if (userUpdateRequest.getEmailAddress().contains("@") && userUpdateRequest.getEmailAddress().contains(".")) {
                    userUpdateResponse.setMessage("Invalid email format");
                    return userUpdateResponse;
                }
                if (userRepository.existsUserByEmailAddress(userUpdateRequest.getEmailAddress())) {
                    userUpdateResponse.setMessage("Email address already in use");
                    return userUpdateResponse;
                }
                foundUser.setEmailAddress(userUpdateRequest.getEmailAddress());
            }
            if (userUpdateRequest.getEmailAddress() != null) {
                foundUser.setAddress(userUpdateRequest.getAddress());
            }
            if (userUpdateRequest.getFirstName() != null) {
                foundUser.setFirstName(userUpdateRequest.getFirstName());
            }
            if (userUpdateRequest.getPassWord() != null) {
                foundUser.setPassword(userUpdateRequest.getPassWord());
            }
            if (userUpdateRequest.getGander() != null) {
                foundUser.setGender(userUpdateRequest.getGander());
            }
            if (userUpdateRequest.getPhoneNumber() != null) {
                foundUser.setPhoneNumber(userUpdateRequest.getPhoneNumber());
            }
            if (userUpdateRequest.getEmailAddress() != null) {
                foundUser.setEmailAddress(userUpdateRequest.getEmailAddress());
            }
            if (userUpdateRequest.getAge() != foundUser.getAge()) {
                foundUser.setAge(userUpdateRequest.getAge());
            }
            userRepository.save(foundUser);
            userUpdateResponse.setMessage("Your account has been updated Successfully");
            return userUpdateResponse;
        } catch (Exception e) {
            userUpdateResponse.setMessage("Error updating user");
        }
        return userUpdateResponse;
    }

    @Override
    public String removeUser(ValidateUserRequest validateUserRequest) {
        User user = userRepository.findUserByEmailAddressAndPassword(validateUserRequest.getEmailAddress().trim().toLowerCase(), validateUserRequest.getPassWord());
        if (user == null) {
            throw new NullPointerException("User not found");
        }
        userRepository.delete(user);
        return "User has been deleted Successfully";
    }

    @Override
    public UserDtoResponse getUserDto(ValidateUserRequest validateUserRequest) {
        User user = userRepository.findUserByEmailAddressAndPassword(validateUserRequest.getEmailAddress().toLowerCase(), validateUserRequest.getPassWord());
        if (user == null) {
            throw new NullPointerException("User not found");
        }
        UserDtoResponse userDtoResponse = new UserDtoResponse();
        userDtoResponse.setAddress(user.getAddress());
        userDtoResponse.setFirstName(user.getFirstName());
        userDtoResponse.setPassWord(user.getPassword());
        userDtoResponse.setUserRole(user.getUserRole());
        userDtoResponse.setAge(user.getAge());
        userDtoResponse.setGender(user.getGender());
        userDtoResponse.setPhoneNumber(user.getPhoneNumber());
        userDtoResponse.setEmailAddress(user.getEmailAddress());
        return userDtoResponse;
    }



}

