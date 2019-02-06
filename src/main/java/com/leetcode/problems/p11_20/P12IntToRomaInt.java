package com.leetcode.problems.p11_20;

/**
 * @author yongxing.chen
 * @date 2018-12-20 下午5:49
 */
public class P12IntToRomaInt {

    private static final int ONE_DIGITS = 0;
    private static final int TEN_DIGITS = 1;
    private static final int HUNDRED_DIGITS = 2;
    private static final int THOUSAND_DIGITS = 3;

    private static final String ONE_ROMA = "I";
    private static final String FIVE_ROMA = "V";
    private static final String TEN_ROMA = "X";
    private static final String FIFTY_ROMA = "L";
    private static final String HUNDRED_ROMA = "C";
    private static final String FIVE_HUNDRED_ROMA = "D";
    private static final String THOUSAND_ROMA = "M";

    private String transformOneNum(int x, int digitCount) {
        if (x > 9 || x < 0) {
            return "";
        }
        switch (digitCount) {
        case ONE_DIGITS :
            return assemblyRoma(x, ONE_ROMA, FIVE_ROMA, TEN_ROMA);
        case TEN_DIGITS :
            return assemblyRoma(x, TEN_ROMA, FIFTY_ROMA, HUNDRED_ROMA);
        case HUNDRED_DIGITS :
            return assemblyRoma(x, HUNDRED_ROMA, FIVE_HUNDRED_ROMA, THOUSAND_ROMA);
        case THOUSAND_DIGITS :
            return assemblyRoma(x, THOUSAND_ROMA, null, null);
        default:
            return null;
        }
    }

    private String assemblyRoma(int x, String one, String five, String ten) {
        if (x < 0 || x > 9) {
            throw new RuntimeException();
        }
        if (x < 4) {
            StringBuilder r = new StringBuilder();
            for (int i = 0; i < x; i++) {
                r.append(one);
            }
            return r.toString();
        } else if (x == 4) {
            return one + five;
        } else if (x < 9){
            StringBuilder r = new StringBuilder(five);
            for (int i = 0; i < x - 5; i ++) {
                r.append(one);
            }
            return r.toString();
        } else {
            return one + ten;
        }
    }

    public String intToRoman(int num) {
        int temp = num;
        int digitCount = 0;
        StringBuilder sb = new StringBuilder();
        do {
            String s = transformOneNum(temp % 10, digitCount);
            sb.insert(0, s);
            temp /= 10;
            digitCount++;
        } while (temp != 0);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P12IntToRomaInt().intToRoman(1994));
    }
}
