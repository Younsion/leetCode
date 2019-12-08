package com.leetcode.problems.exploreAlgorithm.sortAndSearch;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest extends Solution{

    @Test
    public void testMerge() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }
}