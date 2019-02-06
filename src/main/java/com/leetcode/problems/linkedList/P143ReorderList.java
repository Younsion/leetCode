package com.leetcode.problems.linkedList;

/**
 * 143. 重排链表
 * @author yongxing.chen
 * @date 2019-02-01 下午4:13
 */
public class P143ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        ListNode[] listNodes = new ListNode[len];
        node = head;
        for (int i = 0; i < listNodes.length; i++) {
            listNodes[i] = node;
            node = node.next;
        }
        int index = 0;
        node = head;
        for (int i = len - 1; i >=0; i--) {
            if (index >= i) {
                break;
            }
            index++;
            ListNode temp = node.next;
            node.next = listNodes[i];
            node.next.next = temp;
            node = temp;
        }
        node.next = null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        new P143ReorderList().reorderList(node);
        System.out.println(node);
    }
}
