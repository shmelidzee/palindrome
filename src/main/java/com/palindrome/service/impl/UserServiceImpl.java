package com.palindrome.service.impl;

import com.palindrome.domain.User;
import com.palindrome.repository.UserRepository;
import com.palindrome.service.StaticService;
import com.palindrome.service.UserService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final StaticService staticService = new StaticServiceImpl();
    private final UserRepository userRepository = new UserRepository();

    @Override
    public void addNewWord(String word, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();
        if (staticService.isPalindrome(word, 0) && !user.getActiveWords().contains(word)) {
            user.addNewWord(word);
            user.addScore((long) word.length());
            userRepository.save(user.getId(), user);
        }
    }

    @Override
    public User createNewUser(String name) {
        User user = new User(userRepository.getFreeId(), name, 0L, new ArrayList<>());
        return userRepository.save(user);
    }

    @Override
    public List<User> findTopFiveLeaders() {
        return userRepository.findAll().stream()
                .sorted(Comparator.comparingLong(User::getScore).reversed())
                .limit(5)
                .toList();
    }
}
