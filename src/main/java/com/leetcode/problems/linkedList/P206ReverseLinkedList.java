package com.leetcode.problems.linkedList;

/**
 * 206. 反转链表
 * @author yongxing.chen
 * @date 2019-01-25 下午7:09
 */
public class P206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        ListNode last = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = last;
            last = node;
            node = next;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        System.out.println(new P206ReverseLinkedList().reverseList(node));
    }
}
