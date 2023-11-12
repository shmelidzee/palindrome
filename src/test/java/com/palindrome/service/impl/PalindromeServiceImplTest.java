package com.palindrome.service.impl;

import com.palindrome.service.PalindromeService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeServiceImplTest {

    private final PalindromeService palindromeService = new PalindromeServiceImpl();

    @ParameterizedTest
    @ValueSource(strings = {"Доход", "Топот", "заказ", "шалаш",
            "А роза упала на лапу Азора", "шабаш", "комок"})
    void isPalindrome(String str) {
        assertTrue(palindromeService.isPalindrome(str, 0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "is not palindrome"})
    void isNotPalindrome(String str) {
        assertFalse(palindromeService.isPalindrome(str, 0));
    }
}