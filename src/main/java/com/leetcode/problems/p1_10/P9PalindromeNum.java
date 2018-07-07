package com.leetcode.problems.p1_10;

/**
 * @author yongxing.chen
 * @create 2018-07-07 下午4:11
 */
public class P9PalindromeNum {
    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        long lx = 0, tmpX = x;
        while (tmpX > 0) {
            lx = lx * 10 + tmpX % 10;
            tmpX = tmpX / 10;
        }
        if(lx == x) {
            return true;
        } else{
            return false;
        }
    }

    public static void main(String[] args) {
        isPalindrome(121);
    }
}
