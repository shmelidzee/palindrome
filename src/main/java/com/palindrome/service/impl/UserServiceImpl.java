package com.palindrome.service.impl;

import com.palindrome.domain.User;
import com.palindrome.repository.UserRepository;
import com.palindrome.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createNewUser(String name) {
        User user = new User(userRepository.getFreeId(), name, new ArrayList<>());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElse(null);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user.getId(), user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
