package com.palindrome;

import com.palindrome.service.GameService;
import com.palindrome.service.impl.GameServiceImpl;

public class Main {

    public static void main(String[] args) {
        GameService gameService = new GameServiceImpl();
        gameService.startGame();
    }
}