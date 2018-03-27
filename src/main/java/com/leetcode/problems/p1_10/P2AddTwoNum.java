package com.leetcode.problems.p1_10;

/**
 * @author yongxing.chen
 * @create 2018-03-26 下午8:36
 */
public class P2AddTwoNum {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode tmp = root;
        int highPst = 0;
        for(ListNode tmp1 = l1, tmp2 = l2; tmp1 != null || tmp2 != null || highPst != 0;) {
            int v1 = 0, v2 = 0;
            if (tmp1 != null) {
                v1 = tmp1.val;
                tmp1 = tmp1.next;
            }
            if (tmp2 != null) {
                v2 = tmp2.val;
                tmp2 = tmp2.next;
            }
            tmp.next = new ListNode((v1 + v2 + highPst) % 10);
            tmp = tmp.next;
            highPst = (v1 + v2 + highPst) / 10;
        }
        return root.next;
    }

    public static void main(String[] args) {

    }
}
