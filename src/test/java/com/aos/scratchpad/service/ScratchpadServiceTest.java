package com.aos.scratchpad.service;

import com.aos.scratchpad.service.impl.ScratchpadServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

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


}
