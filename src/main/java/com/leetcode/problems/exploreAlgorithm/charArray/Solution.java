package com.leetcode.problems.exploreAlgorithm.charArray;

/**
 * @author yongxing.chen
 * @date 2019-03-06 上午10:00
 */
public class Solution {
    /**
     * 反转字符串
     *
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     * @param s
     */
    public void reverseString(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            left++;
            right--;
        }
    }

    /**
     * 整数反转
     *
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int y = 0;
        boolean flag = true;
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            flag = false;
            x = x * -1;
        }
        while (x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
            if (x > 0) {
                if (flag) {
                    if (y > Integer.MAX_VALUE / 10) {
                        return 0;
                    } else if (y == Integer.MAX_VALUE / 10 && x % 10 > 7) {
                        return 0;
                    }
                } else {
                    if (y > Integer.MIN_VALUE / 10 * -1) {
                        return 0;
                    } else if (y == Integer.MIN_VALUE / 10 * -1 && x % 10 > 8) {
                        return 0;
                    }
                }
            }
        }
        return !flag ? -1 * y : y;
    }

    /**
     * 字符串中的第一个唯一字符
     *
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s == null || "".equals(s)) {
            return -1;
        }
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a'] = charCount[s.charAt(i) - 'a'] + 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 有效的字母异位词
     *
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sCharCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sCharCounts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            sCharCounts[t.charAt(i) - 'a']--;
        }
        for (int var : sCharCounts) {
            if (var != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 验证回文字符串
     *
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        char[] sChars = new char[s.length()];
        int length = 0;
        //1.提取字母和数字；忽略大小写，字母统一转为小写
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 32);
            } else if (c >= 'a' && c <= 'z') {
            } else if (c >= '0' && c <= '9') {
            } else {
                continue;
            }
            sChars[length] = c;
            length++;
        }
        //2.判断字符串是否回文字符串
        for (int i = 0; i < length; i++) {
            if (sChars[i] != sChars[--length]) {
                return false;
            }
        }
        return true;
    }

}
