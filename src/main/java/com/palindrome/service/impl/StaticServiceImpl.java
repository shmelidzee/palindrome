package com.palindrome.service.impl;

import com.palindrome.service.StaticService;

public class StaticServiceImpl implements StaticService {

    @Override
    public boolean isPalindrome(String inputString, int num) {
        if (inputString == null || inputString.isEmpty()) {
            return false;
        }
        inputString = inputString.replace(" ", "").toLowerCase();
        if (num == Math.floor((double) inputString.length() / 2)) {
            return true;
        }
        if (inputString.charAt(num) != inputString.charAt(inputString.length() - 1 - num)) {
            return false;
        }
        return isPalindrome(inputString, ++num);
    }
}
