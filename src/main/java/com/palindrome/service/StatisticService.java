package com.palindrome.service;

import com.palindrome.domain.User;

import java.util.List;

public interface StatisticService {

    List<User> findTopFiveLeaders();
}
