package com.aos.scratchpad.service;

import com.aos.scratchpad.service.impl.ScratchpadServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
public class ScratchpadServiceTest {
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
}
