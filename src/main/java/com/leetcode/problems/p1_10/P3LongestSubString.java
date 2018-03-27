package com.leetcode.problems.p1_10;

import java.util.LinkedList;

/**
 * @author yongxing.chen
 * @create 2018-03-27 上午10:34
 */
public class P3LongestSubString {
    /*public int lengthOfLongestSubstring(String s) {
        int max = 0;
        boolean[] charPst = new boolean[128];
        LinkedList<Integer> charInt = new LinkedList<Integer>();
        for(int i = 0; i < s.length(); i++) {
            int charAt = s.charAt(i);
            if(charPst[charAt]) {
               for(int j = 0; j < 128; j++) {
                   int val = charInt.poll();
                   charPst[val] = false;
                   if(val == charAt) {
                       break;
                   }
               }
            }
            charPst[charAt] = true;
            charInt.add(charAt);
            if(charInt.size() > max) {
                max = charInt.size();
            }
        }
        return max;
    }*/

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int start = 0, end = 0, max = 0;
        boolean[] charHad = new boolean[128];
        for(int i = 0; i < s.length(); i++) {
            int charAt = s.charAt(i);
            if(charHad[charAt]) {
                for(int j = start; j < end; j++) {
                    int val = s.charAt(j);
                    start++;
                    charHad[val] = false;
                    if(val == charAt) {
                        break;
                    }
                }
            }
            charHad[charAt] = true;
            end++;
            if((end - start) > max) {
                max = end - start;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String string = "bpfbhmipx";
        int i = new P3LongestSubString().lengthOfLongestSubstring(string);
    }
}
