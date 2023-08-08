package com.aos.scratchpad.service.intf;


import com.aos.scratchpad.dto.ListNode;

import java.util.List;

public interface ScratchpadService {
    int[] twoSumIntArray(int[] nums, int target);

    List<Long> twoSumList(List<Long> nums, Long target);

    ListNode addTwoNumbers(ListNode l1, ListNode l2);

    Long lengthOfLongestSubstring(String s);

    double findMedianSortedArrays(int[] nums1, int[] nums2);

    String longestPalindrome(String s);

    String zigzagConversion(String s, int numRows);

    int reverseInteger(int x);
}
