package com.leetcode.problems.exploreAlgorithm.sortAndSearch;

/**
 * @author zrom
 * @date 2019/12/8
 **/
public class Solution {
    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     *
     * 说明:
     *
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] lastInts = null;
        int lastCount = 0;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }
        if (m > 0) {
            lastCount = m;
            lastInts = nums1;
        } else if (n > 0) {
            lastCount = n;
            lastInts = nums2;
        }
        while (lastCount > 0) {
            nums1[lastCount - 1] = lastInts[lastCount - 1];
            lastCount--;
        }
    }

}
