package com.palindrome.service.impl;

import com.palindrome.domain.User;
import com.palindrome.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatisticServiceImplTest {
    private final UserServiceImpl userService = new UserServiceImpl(new UserRepository());
    private final StatisticServiceImpl statisticService = new StatisticServiceImpl(userService);

    @Test
    void shouldReturnTopFiveLeaders() {
        User one = userService.createNewUser("Test one");
        User two = userService.createNewUser("Test two");
        User three = userService.createNewUser("Test three");
        one.addScore(5L);
        userService.updateUser(one);

        assertEquals(3, statisticService.findTopFiveLeaders().size());
        assertEquals(5L, statisticService.findTopFiveLeaders().get(0).getScore());
    }
}