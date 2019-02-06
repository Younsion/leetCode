package com.leetcode.problems.linkedList;

/**
 * @author yongxing.chen
 * @date 2018-12-29 下午5:30
 */
public class P21MergeTwoSortedLinkedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(-1);
        ListNode temp = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
                temp = temp.next;
            } else {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
                temp = temp.next;
            }
        }
        ListNode notNullNode = l1 == null ? l2 : l1;
        // 其实可以直接接剩下的链表，不过考虑到方法一般不要对参数造成影响，这里不用那种方法
        while (notNullNode != null) {
            temp.next = new ListNode(notNullNode.val);
            notNullNode = notNullNode.next;
            temp = temp.next;
        }
        return newNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        System.out.println(new P21MergeTwoSortedLinkedList().mergeTwoLists(node1, node2));
    }
}
