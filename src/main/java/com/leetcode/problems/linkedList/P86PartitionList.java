package com.leetcode.problems.linkedList;

/**
 * 86. 分隔链表
 *
 * @author yongxing.chen
 * @date 2019-01-21 下午8:18
 */
public class P86PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        ListNode leftHead = null;
        ListNode rightHead = null;
        ListNode lessNode = null;
        ListNode greaterNode = null;
        while (node != null) {
            if (node.val < x) {
                if (lessNode == null) {
                    lessNode = node;
                    leftHead = node;
                } else {
                    lessNode.next = node;
                    lessNode = lessNode.next;
                }
            } else {
                if (greaterNode == null) {
                    greaterNode = node;
                    rightHead = node;
                } else {
                    greaterNode.next = node;
                    greaterNode = greaterNode.next;
                }
            }
            node = node.next;
        }
        if (greaterNode != null) {
            greaterNode.next = null;
        }
        if (lessNode != null && rightHead != null) {
            lessNode.next = rightHead;
        }
        if (leftHead == null) {
            leftHead = rightHead;
        }
        return leftHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);
        System.out.println(new P86PartitionList().partition(node, 3));
    }
}
