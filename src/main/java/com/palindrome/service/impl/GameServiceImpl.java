package com.palindrome.service.impl;

import com.palindrome.domain.User;
import com.palindrome.service.GameService;
import com.palindrome.service.PalindromeService;
import com.palindrome.service.StatisticService;
import com.palindrome.service.UserService;

public class GameServiceImpl implements GameService {

    private final UserService userService;
    private final StatisticService statisticService;
    private final PalindromeService palindromeService;

    public GameServiceImpl(UserService userService, StatisticService statisticService, PalindromeService palindromeService) {
        this.userService = userService;
        this.statisticService = statisticService;
        this.palindromeService = palindromeService;
    }

    @Override
    public void startGame() {
        User ivan = userService.createNewUser("Ivan");
        User pavel = userService.createNewUser("Pavel");
        User gena = userService.createNewUser("Gena");
        User andrey = userService.createNewUser("Andrey");
        User denis = userService.createNewUser("Denis");
        User dima = userService.createNewUser("Dmitry");

        addNewWord("Доход", ivan.getId());
        addNewWord("Топот", ivan.getId());
        addNewWord("Кабак", pavel.getId());
        addNewWord("Шалаш", gena.getId());
        addNewWord("А роза упала на лапу Азора", andrey.getId());
        addNewWord("заказ", denis.getId());
        addNewWord("Не палиндром, в список лидеров не попал", dima.getId());

        statisticService.findTopFiveLeaders()
                .forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
    }

    @Override
    public void addNewWord(String word, Long userId) {
        User user = userService.getUserById(userId);
        if (palindromeService.isPalindrome(word, 0) && !user.getActiveWords().contains(word)) {
            user.addNewWord(word);
            user.addScore((long) word.length());
            userService.updateUser(user);
        }
    }
}
