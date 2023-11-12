package com.palindrome.service.impl;

import com.palindrome.domain.User;
import com.palindrome.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceImplTest {

    private final UserServiceImpl userService = new UserServiceImpl(new UserRepository());

    @Test
    void shouldCreateNewUser() {
        userService.createNewUser("Test name");

        assertEquals(1, userService.findAllUsers().size());
        assertEquals("Test name", userService.getUserById(1L).getName());
    }

    @Test
    void shouldReturnAllUsers() {
        userService.createNewUser("Test one");
        userService.createNewUser("Test two");
        userService.createNewUser("Test three");

        assertEquals(3, userService.findAllUsers().size());
    }

    @Test
    void shouldUpdateUser() {
        User user = userService.createNewUser("Name");
        user.addScore(5L);
        userService.updateUser(user);

        assertEquals(5, userService.getUserById(1L).getScore());
        assertEquals("Name", userService.getUserById(1L).getName());
    }
}