package com.palindrome.service;

import com.palindrome.domain.User;

import java.util.List;

public interface UserService {

    User createNewUser(String name);

    User getUserById(Long userId);

    void updateUser(User user);

    List<User> findAllUsers();
}
