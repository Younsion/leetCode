package com.leetcode.problems.exploreAlgorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author zrom
 * @date 2019/2/6
 **/
public class Solution {
    /**
     * 从排序数组中删除重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int index = 0,lasVal = 0;
        for (int i=0; i<nums.length; i++) {
            if (index == 0) {
                lasVal = nums[0];
                index++;
                continue;
            }
            if (lasVal != nums[i]) {
                nums[index] = nums[i];
                index++;
                lasVal = nums[i];
            }
        }
        return index;
    }

    /**
     * 买卖股票的最佳时机 II
     * 解法1
     * 模拟买入卖出，每次在极低点买入，极高点卖出
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0, buy = -1;
        boolean hasBuy = false;
        for (int i=0;i<prices.length - 1;i++) {
            if (hasBuy) {
                // 开始降价，要出售
                if (prices[i] > prices[i+1]) {
                    profit += prices[i] - buy;
                    hasBuy = false;
                }
            } else {
                // 开始涨价，要买入了
                if (prices[i] < prices[i+1]) {
                    buy = prices[i];
                    hasBuy = true;
                }
            }
        }
        if (hasBuy) {
            profit += prices[prices.length - 1] - buy;
        }
        return profit;
    }

    /**
     * 买卖股票的最佳时机 II
     * 解法2
     * @param prices
     * @return
     */
    public int maxProfitII(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        for (int i=0;i<prices.length - 1;i++) {
            int tmpProfit = prices[i+1] - prices[i];
            profit += tmpProfit > 0 ? tmpProfit : 0;
        }
        return profit;
    }

    /**
     * 旋转数组
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 1 || k < 0 || k % nums.length == 0) {
            return;
        }
        int index = 0, last = nums[index], count = 0, sp = index;
        do {
            int nextIndex = (index + k) % nums.length;
            int tmpLast = nums[nextIndex];
            nums[nextIndex] = last;
            last = tmpLast;
            index = nextIndex;
            if (index == sp) {
                index++;
                sp = index;
                last = nums[index];
            }
            count++;
        } while (count < nums.length);
    }

    /**
     * 存在重复
     *
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] == max || nums[i] == min){
                return true;
            } else {
                for (int j = 0; j < i; j++) {
                    if (nums[j] == nums[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 只出现一次的数字
     *
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    /**
     * 两个数组的交集 II
     *
     * 给定两个数组，编写一个函数来计算它们的交集。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length < 1) {
            return nums1;
        }
        if (nums2 == null || nums2.length < 1) {
            return nums2;
        }
        int length = 0;
        int[] shorter = nums1.length < nums2.length ? nums1 : nums2;
        int[] longer = shorter == nums1 ? nums2 : nums1;
        boolean[] shorterHappen = new boolean[shorter.length];
        int[] res = new int[shorter.length];
        for (int i = 0; i < longer.length; i++) {
            for (int j = 0; j < shorter.length; j++) {
                if (longer[i] == shorter[j] && !shorterHappen[j]) {
                    shorterHappen[j] = true;
                    res[length] = shorter[j];
                    length++;
                    break;
                }
            }
        }
        return Arrays.copyOfRange(res, 0, length);
    }

    /**
     * 加一
     *
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int add = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i < digits.length - 1 && add != 1) {
                break;
            }
            if (digits[i] + add > 9) {
                digits[i] = 0;
                add=1;
            } else {
                digits[i] = digits[i] + add;
                add = 0;
            }
        }
        if (add >= 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = add;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }
        return digits;
    }

    /**
     * 移动零
     *
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 两数之和
     *
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * @param nums
     * @param target
     * @return 例如：[2, 7, 11, 15] 9, 返回：[2, 7]
     */
    public int[] twoSum(int[] nums, int target) {
        Map map = new HashMap<>(nums.length / 2);
        for (int i = 0; i < nums.length; i++) {
            int ans = target - nums[i];
            Integer ansIndex = (Integer) map.get(ans);
            if (ansIndex != null) {
                return new int[] {ansIndex, i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    /**
     * 有效的数独
     *
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * 1.数字 1-9 在每一行只能出现一次。
     * 2.数字 1-9 在每一列只能出现一次。
     * 3.数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowFlag = new boolean[9][9];
        boolean[][] colFlag = new boolean[9][9];
        boolean[][] boxFlag = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int val = changeCharToInt(board[i][j]);
                int boxIndex = boxIndex(i, j);
                if (val != -1) {
                    if (rowFlag[i][val]) {
                        return false;
                    }
                    if (colFlag[j][val] || boxFlag[boxIndex][val]) {
                        return false;
                    }
                    rowFlag[i][val] = true;
                    colFlag[j][val] = true;
                    boxFlag[boxIndex][val] = true;
                }
            }
        }
        return true;
    }

    private int changeCharToInt(char c) {
        if ('.' == c) {
            return -1;
        } else {
            return c - '1';
        }
    }

    private int boxIndex(int i, int j) {
        int row = i > 2 ? i > 5 ? 2 : 1 : 0;
        int col = j > 2 ? j > 5 ? 2 : 1 : 0;
        return row * 3 + col;
    }

    /**
     * 旋转图像
     *
     * 给定一个 n × n 的二维矩阵表示一个图像。
     * 将图像顺时针旋转 90 度。
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        //根据框来旋转，所以首先判断需要转几个框，再分别转。
        if (matrix == null || matrix.length == 1) {
            return;
        }
        int startRow = 0;
        int endRow = matrix.length - 1;
        int frameIndex = 0;
        while (startRow < endRow) {
            if (startRow + 1 == endRow) {
                int temp1 = matrix[startRow][endRow];
                matrix[startRow][endRow] = matrix[startRow][startRow];
                int temp2 = matrix[endRow][endRow];
                matrix[endRow][endRow]=temp1;
                temp1 = matrix[endRow][startRow];
                matrix[endRow][startRow] = temp2;
                matrix[startRow][startRow] = temp1;
            } else {
                for (int i = startRow; i < endRow; i++) {
                    //第一行->最后一列
                    int temp11 = matrix[i][endRow];
                    matrix[i][endRow] = matrix[startRow][i];
                    //最后一列->最后一行
                    int temp22 = matrix[endRow][endRow - i];
                    matrix[endRow][endRow - i] = temp11;
                    //最后一行->第一列
                    temp11 = matrix[endRow - i][startRow];
                    matrix[endRow - i][startRow] = temp22;
                    //第一列->第一行
                    matrix[startRow][i] = temp11;
                }
            }
            startRow++;
            endRow--;
        }
    }

}
