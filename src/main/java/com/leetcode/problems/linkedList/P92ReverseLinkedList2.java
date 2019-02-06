package com.leetcode.problems.linkedList;

/**
 * @author yongxing.chen
 * @date 2019-01-25 下午7:42
 */
public class P92ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m > n || m < 1) {
            return head;
        }
        int index = 1;
        ListNode node = head;
        ListNode last = null;
        ListNode inLast = null;
        while (node != null) {
            if (index == m) {

                ListNode inNode = node;
                while (inNode != null) {
                    ListNode inNext = inNode.next;
                    inNode.next = inLast;
                    inLast = inNode;
                    inNode = inNext;
                    index++;
                    if (index > n) {
                        break;
                    }
                }

                if (last != null) {
                    last.next = inLast;
                }
                node.next = inNode;
                break;
            }
            index++;
            last = node;
            node = node.next;
        }
        return m==1?inLast:head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(new P92ReverseLinkedList2().reverseBetween(node,1,4));
    }
}
