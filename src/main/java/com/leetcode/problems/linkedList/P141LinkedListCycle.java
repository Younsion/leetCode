package com.leetcode.problems.linkedList;

/**
 * @author yongxing.chen
 * @date 2019-01-30 下午8:02
 */
public class P141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode node = head;
        ListNode fastNode = head;
        while (fastNode != null) {
            node = node.next;
            fastNode = fastNode.next == null ? null : fastNode.next.next;
            if (fastNode == node) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
