package com.leetcode.problems.p1_10;

/**
 * @author yongxing.chen
 * @create 2018-03-30 下午3:55
 */
public class P6ZigzagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        int colNum = (int) (s.length() / 0.001 / numRows) + 1;
        int row = 0, col = 0;
        char[][] chars = new char[numRows][colNum];
        for(int i = 0; i< s.length(); i++) {
            chars[row][col] = s.charAt(i);
            if(row == numRows - 1 || col % (numRows-1) != 0) {
                row--;
                col++;
                continue;
            }
            row++;
        }
        char[] newChars = new char[s.length()];
        int len = 0;
        for (int i =0;i<chars.length;i++) {
            for(int j=0;j<chars[i].length;j++) {
                if(chars[i][j] != 0) {
                    newChars[len] = chars[i][j];
                    len++;
                }
            }
        }
        return new String(newChars);
    }
}
