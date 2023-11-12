package com.palindrome.service.impl;

import com.palindrome.service.PalindromeService;

public class PalindromeServiceImpl implements PalindromeService {

    private static final String SPACE = " ";
    private static final String EMPTY = "";

    @Override
    public boolean isPalindrome(String inputWord, int num) {
        if (inputWord == null || inputWord.isEmpty()) {
            return false;
        }
        inputWord = inputWord.replace(SPACE, EMPTY).toLowerCase();
        if (num == Math.floor((double) inputWord.length() / 2)) {
            return true;
        }
        if (inputWord.charAt(num) != inputWord.charAt(inputWord.length() - 1 - num)) {
            return false;
        }
        return isPalindrome(inputWord, ++num);
    }
}
