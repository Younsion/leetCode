package com.leetcode.problems.linkedList;

/**
 * @author yongxing.chen
 * @date 2019-01-08 下午7:38
 */
public class P24SwapNodesPairsInLinkedList {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = null;
        ListNode node = head;
        ListNode newHead = head.next;
        while (node != null && node.next != null) {
            ListNode tmpNN = node.next.next;
            ListNode tmpN = node.next;
            tmpN.next = node;
            node.next = tmpNN;
            if (last != null) {
                last.next = tmpN;
            }
            last = node;
            node = tmpNN;
        }
        return newHead;
    }
}
