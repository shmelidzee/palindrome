package com.palindrome.service.impl;

import com.palindrome.domain.User;
import com.palindrome.service.StatisticService;
import com.palindrome.service.UserService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticServiceImpl implements StatisticService {

    private final UserService userService;

    public StatisticServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> findTopFiveLeaders() {
        return userService.findAllUsers().stream()
                .sorted(Comparator.comparingLong(User::getScore).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}
