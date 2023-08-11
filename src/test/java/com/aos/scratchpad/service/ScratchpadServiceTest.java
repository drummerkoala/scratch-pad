package com.aos.scratchpad.service;

import com.aos.scratchpad.service.impl.ScratchpadServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ScratchpadServiceTest {
    @InjectMocks
    ScratchpadServiceImpl scratchpadService;

    @Test
    void givenValidInput_whenLengthOfLongestSubstring_thenReturn() {
        // given
        String s = "aab";

        // then
        Long result = scratchpadService.lengthOfLongestSubstring(s);
        assertNotNull(result);
    }

    @Test
    void givenValidInput_whenFindMedianSortedArrays_thenReturn() {
        // given
        int[] nums1 = {1,3};
        int[] nums2 = {2};

        // then
        double result = scratchpadService.findMedianSortedArrays(nums1, nums2);
        assertEquals(2, result);
    }

    @Test
    void givenValidInput_whenFindMedianSortedArrays_thenReturn2() {
        // given
        int[] nums1 = {1,3};
        int[] nums2 = {2,4};

        // then
        double result = scratchpadService.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.5, result);
    }

    @ParameterizedTest
    @MethodSource("com.aos.scratchpad.util.TestHelper#longestPalindromeArgumentProvider")
    void givenValidInput_whenLongestPalindrome_thenReturn(String input, String expected) {
        // then
        String result = scratchpadService.longestPalindrome(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("com.aos.scratchpad.util.TestHelper#zigzagConversionArgumentProvider")
    void givenValidInput_whenZigZagConversion_thenReturn(String s, int numRows, String expected) {
        // then
        String result = scratchpadService.zigzagConversion(s, numRows);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("com.aos.scratchpad.util.TestHelper#reverseIntegerArgumentProvider")
    void givenValidInput_whenReversedInteger_thenReturn(int x, int expected) {
        // then
        int result = scratchpadService.reverseInteger(x);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("com.aos.scratchpad.util.TestHelper#stringToIntegerArgumentProvider")
    void givenValidInput_whenStringToInteger_thenReturn(String s, int expected) {
        // then
        int result = scratchpadService.stringToInteger(s);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("com.aos.scratchpad.util.TestHelper#isPalindromeArgumentProvider")
    void givenValidInput_whenIsPalindrome_thenReturn(int x, boolean expected) {
        // then
        boolean result = scratchpadService.isPalindrome(x);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("com.aos.scratchpad.util.TestHelper#isRegexArgumentProvider")
    void givenValidInput_whenIsRegex_thenReturn(String s, String p, boolean expected) {
        // then
        boolean result = scratchpadService.isRegex(s, p);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("com.aos.scratchpad.util.TestHelper#maxAreaArgumentProvider")
    void givenValidInput_whenMaxArea_thenReturn(int[] height, int expected) {
        // then
        int result = scratchpadService.maxArea(height);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("com.aos.scratchpad.util.TestHelper#intToRomanArgumentProvider")
    void givenValidInput_whenIntegerToRoman_thenReturn(int num, String expected) {
        // then
        String result = scratchpadService.intToRoman(num);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("com.aos.scratchpad.util.TestHelper#romanToIntArgumentProvider")
    void givenValidInput_whenRomanToInteger_thenReturn(String num, int   expected) {
        // then
        int result = scratchpadService.romanToInt(num);
        assertEquals(expected, result);
    }
}
