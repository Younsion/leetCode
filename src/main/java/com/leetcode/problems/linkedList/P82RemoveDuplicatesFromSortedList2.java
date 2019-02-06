package com.leetcode.problems.linkedList;

/**
 * 82. 删除排序链表中的重复元素 II
 * @author yongxing.chen
 * @date 2019-01-08 下午7:41
 */
public class P82RemoveDuplicatesFromSortedList2 {
    /**
     * flag标识是否是重复节点
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = null;
        ListNode node = head;
        ListNode newHead = null;
        boolean flag = true;
        while (node.next != null) {
            if (flag && node.val != node.next.val) {
                if (last == null) {
                    last = node;
                    newHead =last;
                } else {
                    last.next = node;
                    last = last.next;
                }
            } else if (node.val == node.next.val) {
                flag = false;
            } else if (!flag) {
                flag = true;
            }
            node = node.next;
        }
        if (flag) {
            if (last != null) {
                last.next = node;
            } else {
                newHead = node;
                last = node;
            }
            last = last.next;
        }
        if (last != null) {
            last.next = null;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
//        node.next.next.next = new ListNode(3);
//        node.next.next.next.next = new ListNode(2);
//        node.next.next.next.next.next = new ListNode(2);
//        node.next.next.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next.next.next = new ListNode(5);
        System.out.println(new P82RemoveDuplicatesFromSortedList2().deleteDuplicates(node));
    }
}
