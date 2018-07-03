package com.leetcode.problems.p1_10;

/**
 * @author yongxing.chen
 * @create 2018-07-03 下午8:17
 */
public class P7ReverseInt {

    /**
     * 怎么判断溢出？
     * Integer.MAX_VALUE = 2147483647
     * Integer.MIN_VALUE = -2147483648
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int maxCount = 10;
        String maxInt = "2147483647", minInt = "-2147483648";
        boolean isPositive = true;
        String strX = String.valueOf(x);
        if(x < 0) {
            strX = strX.replace("-", "");
            isPositive = false;
        }
        if(strX.length() == maxCount) {
            for(int i = maxCount - 1; i >= 0; i--) {
                if(i == 0) {
                    if(!isPositive) {
                        if((strX.charAt(i) -'0') > (minInt.charAt(maxCount - 1 - i) - '0')) {
                            return 0;
                        }
                    }
                    break;
                }
                if((strX.charAt(i) -'0') > (maxInt.charAt(maxCount - 1 - i) -'0')) {
                    return 0;
                } else if((strX.charAt(i) -'0') < (maxInt.charAt(maxCount - 1 - i) -'0')) {
                    break;
                }
            }
        }
        int newX = 0;
        for(int i = strX.length() - 1; i >= 0; i--) {
            newX = newX * 10 + strX.charAt(i) - '0';
        }
        if(!isPositive) {
            newX = newX * -1;
        }
        return newX;
    }

    public static void main(String[] args) {
//        System.out.println(reverse(1563847412));
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
    }

}
