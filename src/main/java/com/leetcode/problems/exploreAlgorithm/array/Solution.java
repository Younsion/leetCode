package com.leetcode.problems.exploreAlgorithm.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author zrom
 * @date 2019/2/6
 **/
public class Solution {
    /**
     * 从排序数组中删除重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int index = 0,lasVal = 0;
        for (int i=0; i<nums.length; i++) {
            if (index == 0) {
                lasVal = nums[0];
                index++;
                continue;
            }
            if (lasVal != nums[i]) {
                nums[index] = nums[i];
                index++;
                lasVal = nums[i];
            }
        }
        return index;
    }

    /**
     * 买卖股票的最佳时机 II
     * 解法1
     * 模拟买入卖出，每次在极低点买入，极高点卖出
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0, buy = -1;
        boolean hasBuy = false;
        for (int i=0;i<prices.length - 1;i++) {
            if (hasBuy) {
                // 开始降价，要出售
                if (prices[i] > prices[i+1]) {
                    profit += prices[i] - buy;
                    hasBuy = false;
                }
            } else {
                // 开始涨价，要买入了
                if (prices[i] < prices[i+1]) {
                    buy = prices[i];
                    hasBuy = true;
                }
            }
        }
        if (hasBuy) {
            profit += prices[prices.length - 1] - buy;
        }
        return profit;
    }

    /**
     * 买卖股票的最佳时机 II
     * 解法2
     * @param prices
     * @return
     */
    public int maxProfitII(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        for (int i=0;i<prices.length - 1;i++) {
            int tmpProfit = prices[i+1] - prices[i];
            profit += tmpProfit > 0 ? tmpProfit : 0;
        }
        return profit;
    }

    /**
     * 旋转数组
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 1 || k < 0 || k % nums.length == 0) {
            return;
        }
        int index = 0, last = nums[index], count = 0, sp = index;
        do {
            int nextIndex = (index + k) % nums.length;
            int tmpLast = nums[nextIndex];
            nums[nextIndex] = last;
            last = tmpLast;
            index = nextIndex;
            if (index == sp) {
                index++;
                sp = index;
                last = nums[index];
            }
            count++;
        } while (count < nums.length);
    }

    /**
     * 存在重复
     *
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] == max || nums[i] == min){
                return true;
            } else {
                for (int j = 0; j < i; j++) {
                    if (nums[j] == nums[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 只出现一次的数字
     *
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    /**
     * 两个数组的交集 II
     *
     * 给定两个数组，编写一个函数来计算它们的交集。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length < 1) {
            return nums1;
        }
        if (nums2 == null || nums2.length < 1) {
            return nums2;
        }
        int length = 0;
        int[] shorter = nums1.length < nums2.length ? nums1 : nums2;
        int[] longer = shorter == nums1 ? nums2 : nums1;
        boolean[] shorterHappen = new boolean[shorter.length];
        int[] res = new int[shorter.length];
        for (int i = 0; i < longer.length; i++) {
            for (int j = 0; j < shorter.length; j++) {
                if (longer[i] == shorter[j] && !shorterHappen[j]) {
                    shorterHappen[j] = true;
                    res[length] = shorter[j];
                    length++;
                    break;
                }
            }
        }
        return Arrays.copyOfRange(res, 0, length);
    }

}
