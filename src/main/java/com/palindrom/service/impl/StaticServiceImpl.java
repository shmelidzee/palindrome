package com.palindrom.service.impl;

import com.palindrom.service.StaticService;

public class StaticServiceImpl implements StaticService {

    @Override
    public boolean isPalindrome(String inputString, int num) {
        if (num == Math.floor((double) inputString.length() / 2)) {
            return true;
        }
        if (inputString.charAt(num) != inputString.charAt(inputString.length() - 1 - num)) {
            return false;
        }
        return isPalindrome(inputString, ++num);
    }
}
