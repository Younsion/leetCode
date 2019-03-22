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
     * 只要数字长度小于IntMax的长度，无论如何翻转都不会移除；
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

}
