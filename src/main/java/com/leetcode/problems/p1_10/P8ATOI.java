package com.leetcode.problems.p1_10;

/**
 * @author yongxing.chen
 * @create 2018-07-05 下午9:13
 */
public class P8ATOI {
    public static char POSITIVE_SIGN = '+';
    public static char NEGATIVE_SIGN = '-';
    public static String INT_MAX = "2147483647";
    public static String INT_MIN = "2147483648";
    public static int MAX_LEN = 10;

    public static int myAtoi(String str) {
        if(str == null) {
            return 0;
        }
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }
        boolean isPst = true;
        if(str.charAt(0) == POSITIVE_SIGN) {
            str = str.substring(1);
            isPst = true;
        } else if (str.charAt(0) == NEGATIVE_SIGN) {
            str = str.substring(1);
            isPst = false;
        }
        if(str.length() == 0 || str.charAt(0) < '0' || str.charAt(0) > '9') {
            return 0;
        }

        String valueStr = str;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                valueStr = str.substring(0, i);
                break;
            }
        }
        for(int i = 0; i < valueStr.length(); i++) {
            if(str.charAt(i) != '0') {
                valueStr = valueStr.substring(i, valueStr.length());
                break;
            }
            if(i == valueStr.length() - 1) {
                return 0;
            }
        }
        int valueInt = 0;
        if(valueStr.length() > MAX_LEN) {
            if(isPst) {
                valueInt = Integer.MAX_VALUE;
            } else {
                valueInt = Integer.MIN_VALUE;
            }

        } else if (valueStr .length() == MAX_LEN) {
            for(int i = 0; i < valueStr.length(); i++) {
                if(isPst) {
                    if(valueStr.charAt(i) > INT_MAX.charAt(i)) {
                        valueInt = Integer.MAX_VALUE;
                        break;
                    }
                    if(valueStr.charAt(i) < INT_MAX.charAt(i)) {
                        valueInt = Integer.valueOf(valueStr);
                        break;
                    }
                    if(i == MAX_LEN - 1) {
                        valueInt = Integer.valueOf(valueStr);
                    }
                } else {
                    if(valueStr.charAt(i) > INT_MIN.charAt(i)) {
                        valueInt = Integer.MIN_VALUE;
                        break;
                    }
                    if(valueStr.charAt(i) < INT_MIN.charAt(i)) {
                        valueInt = Integer.valueOf("-" + valueStr);
                        break;
                    }
                    if(i == MAX_LEN - 1) {
                        valueInt = Integer.valueOf("-" + valueStr);
                    }
                }
            }
        } else {
            if(!isPst) {
                valueStr = "-" + valueStr;
            }
            valueInt = Integer.valueOf(valueStr);
        }
        return valueInt;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483647"));
    }
}
