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
        int firstIndex = 0;
        int secIndex = 0;

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
        if (s.length() == 1 || s.length() == 0)
            return s;
        String result = "";
        for (int i = 0; i < s.length(); i++) {

            if (s.length() - i <= result.length())
                break;

            for (int j = s.length() - 1; j >= i; j--) {
                if (result.length() != 0  && j - i < result.length())
                    break;
                else if (s.charAt(i) == s.charAt(j) &&
                        (Boolean.TRUE.equals(longestPalindromeHelper(s.substring(i, j + 1), j - i + 1)))) {
                        result = s.substring(i, j + 1);
                }
            }
        }

        return result;
    }

    private boolean longestPalindromeHelper(String s, int endIndex) {
        int firstIndex = 0;
        int secIndex = endIndex - 1;
        boolean palindromeFlag = true;

        while (firstIndex < secIndex) {
            if (s.charAt(firstIndex) != s.charAt(secIndex)) {
                palindromeFlag = false;
                break;
            }
            firstIndex++;
            secIndex--;
        }

        return palindromeFlag;
    }

    @Override
    public String zigzagConversion(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows || s.length() == 0)
            return s;

        String[] resultList = new String[numRows];
        Arrays.fill(resultList, "");

        int maxRowIndex = numRows - 1;
        int bounceCount;

        for (int i = 0; i < s.length(); i++) {
            bounceCount = i / maxRowIndex;
            if (bounceCount % 2 == 0)
                resultList[i - maxRowIndex * bounceCount] += s.charAt(i);
            else {
                resultList[maxRowIndex - (i - maxRowIndex * bounceCount)] += s.charAt(i);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String stringRow : resultList)
            result.append(stringRow);

        return result.toString();
    }

    public int reverseInteger(int x) {
        int reversedInt = 0;
        int lastDigit;

        while (x != 0) {
            lastDigit = x % 10;
            x = x / 10;
            if (Integer.MAX_VALUE/10 < reversedInt || (Integer.MAX_VALUE/10 == reversedInt && lastDigit > 7))
                return 0;
            if (Integer.MIN_VALUE/10 > reversedInt || (Integer.MIN_VALUE/10 == reversedInt && lastDigit < -8))
                return 0;
            reversedInt = reversedInt * 10 + lastDigit;
        }

        return reversedInt;
    }

    public int stringToInteger(String s) {
        if (s == null || s.length() == 0)
            return 0;
        String trimmedString = s.trim();
        StringBuilder resultStringBuilder = new StringBuilder();
        String resultString;
        int sign = 1;
        boolean ifFirstDigitArrived = false;
        boolean ifSignIsDecided = false;

        long result;

        int index = 0;

        while (index < trimmedString.length()) {
            if (!ifSignIsDecided && (trimmedString.charAt(index) == '+' || trimmedString.charAt(index) == '-')) {
                sign = trimmedString.charAt(index) == '+' ? 1 : -1;
                ifSignIsDecided = true;
            }
            else if (Character.isDigit(trimmedString.charAt(index))) {
                resultStringBuilder.append(trimmedString.charAt(index));
                ifFirstDigitArrived = true;
                ifSignIsDecided = true;
            }
            else if ((!ifFirstDigitArrived) && !Character.isDigit(trimmedString.charAt(index)))
                return 0;
            else if (ifFirstDigitArrived)
                break;
            index++;
        }
        resultString = resultStringBuilder.toString().replaceFirst("^0+(?!$)", "");
        if (resultString.equals(""))
            return 0;
        if (resultString.length() > 10)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        result = Long.parseLong(resultString) * sign;

        if (sign == 1 && result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (sign == -1 && result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int) result;
    }
    @Override
    public boolean isPalindrome(int x) {
        StringBuilder reversedInt = new StringBuilder(String.valueOf(x)).reverse();
        return reversedInt.toString().equals(String.valueOf(x));
    }
}
