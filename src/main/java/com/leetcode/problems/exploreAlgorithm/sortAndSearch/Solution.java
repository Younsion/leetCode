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

    private boolean isBadVersion(int version) {
        return version >= 4;
    }

    /**
     * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
     *
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     *
     * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 0, right = n, middle = (right - left) / 2 + left;
        while(middle > left) {
            if(isBadVersion(middle)) {
                right = middle;
                middle = (middle - left) / 2 + left;
            } else {
                left = middle;
                middle = (right - middle) / 2 + middle;
            }
        }
        return isBadVersion(middle) ? middle : middle + 1;
    }

}
