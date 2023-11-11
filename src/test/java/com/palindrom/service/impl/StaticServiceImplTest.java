package com.palindrom.service.impl;

import com.palindrom.service.StaticService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StaticServiceImplTest {

    private final StaticService staticService = new StaticServiceImpl();

    @ParameterizedTest
    @ValueSource(strings = {"�����", "�����", "�����", "�����",
            "� ���� ����� �� ���� �����", "�����", "�����"})
    void isPalindrome(String str) {
        assertTrue(staticService.isPalindrome(str, 0));
    }
}