package com.leetcode.problems.exploreAlgorithm.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest extends Solution {

    @Test
    public void testRemoveDuplicates() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);
        Assert.assertEquals(len, 5);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
    }

    @Test
    public void testMaxProfit1() {
        int[] nums = {7,1,5,3,6,4};
        int maxProfit = maxProfit(nums);
        Assert.assertEquals(maxProfit, 7);
    }

    @Test
    public void testMaxProfit2() {
        int[] nums = {1,2,3,4,5};
        int maxProfit = maxProfit(nums);
        Assert.assertEquals(maxProfit, 4);
    }

    @Test
    public void testMaxProfit3() {
        int[] nums = {7,6,4,3,1};
        int maxProfit = maxProfit(nums);
        Assert.assertEquals(maxProfit, 0);
    }

    @Test
    public void testMaxProfitII1() {
        int[] nums = {7,1,5,3,6,4};
        int maxProfit = maxProfitII(nums);
        Assert.assertEquals(maxProfit, 7);
    }

    @Test
    public void testMaxProfitII2() {
        int[] nums = {1,2,3,4,5};
        int maxProfit = maxProfitII(nums);
        Assert.assertEquals(maxProfit, 4);
    }

    @Test
    public void testMaxProfitII3() {
        int[] nums = {7,6,4,3,1};
        int maxProfit = maxProfitII(nums);
        Assert.assertEquals(maxProfit, 0);
    }

    @Test
    public void testRotate() {
        int[] nums = {1,2,3,4,5,6};
        rotate(nums, 2);
        Assert.assertTrue(Arrays.equals(nums, new int[]{5,6,1,2,3,4}));
    }

    @Test
    public void testContainsDuplicate() {
        boolean b = containsDuplicate(new int[] { 1, 5, -2, -4, 0 });
    }

    @Test
    public void testIntersect() {
        System.out.println(Arrays.toString(intersect(new int[] { 1, 2, 2, 1}, new int[] { 2,2 })));
        System.out.println(Arrays.toString(intersect(new int[] { 4,9,5}, new int[] { 9,4,9,8,4 })));
    }

    @Test
    public void testRotate90() {
        int[][] ints = new int[][]{{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        rotate(ints);
        for (int[] tt : ints) {
            System.out.println(Arrays.toString(tt));
        }
    }

}
