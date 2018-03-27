package com.leetcode.problems.p1_10;

import java.util.HashSet;
import java.util.List;

/**
 * @author yongxing.chen
 * @create 2018-03-27 上午11:59
 */
public class P4MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length,
                index1 = 0, index2 = 0;
        double middle = totalLen / 2.0, median = 0;
        for(int i = 0; i <= middle; i++) {
            int indexVal = 0;
            if(index1 >= nums1.length) {
                indexVal = nums2 [index2];
                index2++;
            } else if(index2 >= nums2.length) {
                indexVal = nums1 [index1];
                index1++;
            } else if (nums1[index1] < nums2[index2]) {
                indexVal = nums1 [index1];
                index1++;
            } else {
                indexVal = nums2 [index2];
                index2++;
            }
            if(i >= middle - 1 && i <= middle) {
                median = median + indexVal;
            }
        }
        return totalLen % 2 > 0 ? median : median / 2.0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3}, nums2 = new int[]{2};
        new P4MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
    }
}
