package com.aos.scratchpad.service.impl;


import com.aos.scratchpad.dto.ListNode;
import com.aos.scratchpad.service.intf.ScratchpadService;

import java.util.*;

public class ScratchpadServiceImpl implements ScratchpadService {

    @Override
    public int[] twoSumIntArray(int[] nums, int target) {
        Map<Integer, Integer> totalValueMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (totalValueMap.containsKey(target - nums[i]))
                return new int[] {totalValueMap.get(target - nums[i]), i};
            totalValueMap.put(nums[i], i);
        }
        return null;
    }

    @Override
    public List<Long> twoSumList(List<Long> nums, Long target){
        List<Long> result = new ArrayList<>();
        for (Long num: nums) {
            if (nums.contains(target - num)) {
                result.add((long) nums.indexOf(num));
                result.add((long) nums.indexOf(target - num));
                return result;
            }
        }
        return result;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode returnNode = new ListNode((l1.getVal() + l2.getVal()) % 10);
        ListNode nextNode = returnNode;

        int carry = (l1.getVal() + l2.getVal()) / 10;
        l1 = l1.getNext();
        l2 = l2.getNext();

        while (l1 != null || l2 != null || carry != 0) {
            nextNode.setNext(new ListNode(((l1 != null ? l1.getVal() : 0) + (l2 != null ? l2.getVal() : 0) + carry) % 10));
            carry = ((l1 != null ? l1.getVal() : 0) + (l2 != null ? l2.getVal() : 0) + carry) / 10;
            nextNode = nextNode.getNext();
            if (l1 != null)
                l1 = l1.getNext();
            if (l2 != null)
                l2 = l2.getNext();
        }

        return returnNode;
    }

    @Override
    public Long lengthOfLongestSubstring(String s) {
        int maxLen = s.length() > 0 ? 1 : 0;

        Set<Character> tempCharList = new HashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {
            int localMaxLen = 1;
            tempCharList.add(s.charAt(i));
            for (char c : s.substring(i + 1).toCharArray()) {
                if (!tempCharList.contains(c)) {
                    tempCharList.add(c);
                    localMaxLen++;
                }
                else {
                    tempCharList.clear();
                    break;
                }
                if (localMaxLen > maxLen) {
                    maxLen = localMaxLen;
                }
            }
        }

        return (long) maxLen;
    }
    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> sortedCombinedArray = new ArrayList<>();
        int firstIndex = 0, secIndex = 0;

        while (firstIndex <= nums1.length && secIndex <= nums2.length) {
            if (firstIndex == nums1.length) {
                while (secIndex < nums2.length) {
                    sortedCombinedArray.add(nums2[secIndex]);
                    secIndex++;
                }
                break;
            }
            else if (secIndex == nums2.length) {
                while (firstIndex < nums1.length) {
                    sortedCombinedArray.add(nums1[firstIndex]);
                    firstIndex++;
                }
                break;
            }

            if (nums1[firstIndex] < nums2[secIndex]) {
                sortedCombinedArray.add(nums1[firstIndex]);
                firstIndex++;
            }
            else if (nums2[secIndex] < nums1[firstIndex]) {
                sortedCombinedArray.add(nums2[secIndex]);
                secIndex++;
            }
            else {
                sortedCombinedArray.add(nums1[firstIndex]);
                sortedCombinedArray.add(nums2[secIndex]);
                firstIndex++;
                secIndex++;
            }
        }

        if ((nums1.length + nums2.length) % 2 == 1) {
            return sortedCombinedArray.get((nums1.length + nums2.length - 1) / 2);
        }
        else {
            return (sortedCombinedArray.get((nums1.length + nums2.length) / 2 - 1) + sortedCombinedArray.get((nums1.length + nums2.length) / 2)) / 2.0;
        }

    }

    @Override
    public String longestPalindrome(String s) {
        return "";
    }
}
