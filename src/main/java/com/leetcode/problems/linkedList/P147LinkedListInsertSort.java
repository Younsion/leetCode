package com.leetcode.problems.linkedList;

/**
 * @author yongxing.chen
 * @date 2018-12-19 下午7:43
 */
public class P147LinkedListInsertSort {
    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next==null) {
            return head;
        }
        ListNode newHead = new ListNode(head.val);
        ListNode index = head.next;
        while (index != null) {
            ListNode lastNode = null;
            ListNode node = newHead;
            while (node != null && index.val > node.val) {
                lastNode = node;
                node = node.next;
            }
            ListNode newNode = new ListNode(index.val);
            if (lastNode != null) {
                lastNode.next = newNode;
            } else {
                newHead = newNode;
            }
            newNode.next = node;
            index = index.next;
        }
        return newHead;
    }

    /**
     * TODO
     * @param head
     * @return
     */
    public static ListNode insertionSortList2(ListNode head) {
        if(head == null || head.next==null) {
            return head;
        }
        ListNode sortedList = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode curNext = cur.next;
            ListNode lastNode = null;
            ListNode node = sortedList;
            while (node != cur && cur.val > node.val) {
                lastNode = node;
                node = node.next;
            }
            if (lastNode != null) {
                lastNode.next = cur;
            } else {
                sortedList = cur;
            }
            cur.next = node;
            cur = curNext;
        }
        return sortedList;
    }

    public static void main(String[] args) throws InterruptedException {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        ListNode listNode = insertionSortList2(node);
        while (listNode != null) {
            Thread.sleep(500);
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
