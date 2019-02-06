package com.leetcode.problems.linkedList;

/**
 * @author yongxing.chen
 * @date 2019-01-30 下午8:09
 */
public class P142LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode node = head;
        ListNode fastNode = head;
        boolean hasCycle = false;
        while (fastNode != null) {
            node = node.next;
            fastNode = fastNode.next == null ? null : fastNode.next.next;
            if (fastNode == node) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            fastNode = head;
            while (fastNode != null) {
                if (fastNode == node) {
                    return node;
                }
                fastNode = fastNode.next;
                node = node.next;
            }
        }
        return null;
    }
}
