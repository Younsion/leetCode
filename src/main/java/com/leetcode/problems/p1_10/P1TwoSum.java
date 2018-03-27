package com.leetcode.problems.p1_10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yongxing.chen
 * @create 2018-03-26 下午8:18
 */
public class P1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0;
        for(; i < nums.length; i++) {
            Integer need = target - nums[i];
            if(map.get(need) == null) {
                map.put(nums[i], i);
                continue;
            }
            break;
        }
        return new int[]{i, map.get(target - nums[i])};
    }

    public static void main(String[] args) {
        int[] ints = new P1TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(ints[0] + " " + ints[1]);
    }
}
