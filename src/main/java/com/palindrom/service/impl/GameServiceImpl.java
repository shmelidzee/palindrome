package com.palindrom.service.impl;

import com.palindrom.domain.User;
import com.palindrom.service.GameService;
import com.palindrom.service.UserService;

public class GameServiceImpl implements GameService {

    private final UserService userService = new UserServiceImpl();

    @Override
    public void startGame() {
        User ivan = userService.createNewUser("Ivan");
        User pavel = userService.createNewUser("Pavel");
        User gena = userService.createNewUser("Gena");
        User andrey = userService.createNewUser("Andrey");
        User denis = userService.createNewUser("Denis");
        User dima = userService.createNewUser("Dmitry");

        userService.addNewWord("Доход", ivan.getId());
        userService.addNewWord("Топот", ivan.getId());
        userService.addNewWord("Кабак", pavel.getId());
        userService.addNewWord("Шалаш", gena.getId());
        userService.addNewWord("А роза упала на лапу Азора", andrey.getId());
        userService.addNewWord("заказ", denis.getId());
        userService.addNewWord("Не палиндром, в список лидеров не попал", dima.getId());

        userService.findTopFiveLeaders()
                .forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
    }
}
