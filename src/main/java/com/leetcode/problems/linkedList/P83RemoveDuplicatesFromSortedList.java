package com.leetcode.problems.linkedList;

/**
 * 83. 删除排序链表中的重复元素
 * @author yongxing.chen
 * @date 2019-01-14 下午9:01
 */
public class P83RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode last = head;
        while (next != null) {
            if (last.val != next.val) {
                last.next = next;
                last = last.next;
            }
            next = next.next;
        }
        last.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next.next = new ListNode(5);
        System.out.println(new P83RemoveDuplicatesFromSortedList().deleteDuplicates(node));
    }
}
