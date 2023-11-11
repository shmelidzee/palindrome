package com.palindrom.service;

import com.palindrom.domain.User;

import java.util.List;

public interface UserService {

    void addNewWord(String word, Long userId);

    User createNewUser(String name);

    List<User> findTopFiveLeaders();
}
