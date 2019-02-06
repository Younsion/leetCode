package com.leetcode.problems.linkedList;

import com.leetcode.problems.linkedList.ListNode;

/**
 * @author yongxing.chen
 * @date 2018-12-29 上午10:24
 */
public class P19RemoveEndNthNodeFromLinkedList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        int index = len - n;
        ListNode lastNode = null;
        node = head;
        while (index-- > 0) {
            lastNode = node;
            node = node.next;
        }
        if (lastNode != null) {
            lastNode.next = node.next;
        } else {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        removeNthFromEnd(node, 2);
    }
}
