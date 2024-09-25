package com.semicolon.data.repositories;

import com.semicolon.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findUserByEmailAddressAndPassword(String emailAddress, String password);
  Boolean existsUserByEmailAddress(String emailAddress);
}
