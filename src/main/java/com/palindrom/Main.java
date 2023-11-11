package com.palindrom;

import com.palindrom.service.GameService;
import com.palindrom.service.impl.GameServiceImpl;

public class Main {

    public static void main(String[] args) {
        GameService gameService = new GameServiceImpl();
        gameService.startGame();
    }
}