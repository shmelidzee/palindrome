package com.palindrome;

import com.palindrome.repository.UserRepository;
import com.palindrome.service.GameService;
import com.palindrome.service.impl.GameServiceImpl;
import com.palindrome.service.impl.PalindromeServiceImpl;
import com.palindrome.service.impl.StatisticServiceImpl;
import com.palindrome.service.impl.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl(new UserRepository());
        StatisticServiceImpl statisticService = new StatisticServiceImpl(userService);
        PalindromeServiceImpl palindromeService = new PalindromeServiceImpl();

        GameService gameService = new GameServiceImpl(userService, statisticService, palindromeService);
        gameService.startGame();
    }
}