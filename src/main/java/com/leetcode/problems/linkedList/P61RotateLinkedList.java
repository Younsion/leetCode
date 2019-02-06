package com.leetcode.problems.linkedList;

/**
 * @author yongxing.chen
 * @date 2019-01-08 下午7:37
 */
public class P61RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k < 1) {
            return head;
        }

        // 判断链表长度
        int len = 1;
        ListNode node = head;
        while(node.next != null) {
            len++;
            node = node.next;
        }

        // 构建循环链表
        k = k % len;
        node.next = head;

        // 找新头
        int offset = len - k;
        ListNode last = node;
        node = head;
        while (offset-- > 0) {
            last = node;
            node = node.next;
        }

        //斩断循环链表
        last.next = null;
        return node;
    }
}
