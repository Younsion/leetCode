package com.leetcode.problems.p11_20;

/**
 * @author yongxing.chen
 * @create 2018-07-13 下午5:09
 */
public class P11ContainWater {
    /**
     * 穷举法
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0;
        int lastShort = 0;
        for(int i = 0; i < height.length - 1; i++) {
            for(int j = i + 1; j < height.length; j++) {
                lastShort = height[i] > height[j] ? height[j] : height[i];
                int tmp = lastShort * (j - i);
                max = max > tmp ? max : tmp;
            }
        }
        return max;
    }

    /**
     * 类快排法
     * 1.取最左和最右两端点
     * 2.计算两点值
     * 3.然后从两点中较小的点开始向另一方向取值，取到比他大的值取代
     * 4.重复2和3，直到没有合适为止
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int leftP = 0;
        int rightP = height.length - 1;
        while (leftP < rightP) {
            int temp = height[leftP] > height[rightP] ? height[rightP] * (rightP - leftP) : height[leftP] * (rightP - leftP);
            max = temp > max ? temp : max;
            if (height[leftP] < height[rightP]) {
                while (leftP < rightP && height[leftP] > height[++leftP]) {
                }
            } else {
                while (leftP < rightP && height[rightP] > height[--rightP]) {
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea2(new int[]{1,2}));
    }
}
