package com.leetcode.problems.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yongxing.chen
 * @date 2018-12-27 上午11:45
 */
public class P160IntersectedLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        Set<ListNode> set = new HashSet<ListNode>();
        while (temp1 != null) {
            set.add(temp1);
            temp1 = temp1.next;
        }
        ListNode temp2 = headB;
        while (temp2 != null) {
            if (set.contains(temp2)) {
                return temp2;
            }
            temp2 = temp2.next;
        }
        return null;
    }

    /**
     * 1.
     * 设两个临时指针分别指向两个链表，每个链表的尾节点接另一个链表的头结点
     * 遍历两个临时链表，如果有相遇的点，则那一点开始就是相交链表的起始点
     * 证明：
     * 设A链表的的长度为a+c，B链表的长度为b+c，其中a是A链表独有的长度，b是b链表独有的长度，c是两链表共有的长度（可以为0，即无交点）。
     * 那么(a+c)+b+c = (b+c)+a+c
     * 可以看到，两个临时链表同时走，最终一定会同时走到相交节点，因为走过的长度是一样的（当然相交节点可以是null，说明无交点）
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode temp1 = headA, temp2 = headB;
        while (temp1 != temp2) {
            temp1 = temp1 == null ? headB : temp1.next;
            temp2 = temp2 == null ? headA : temp2.next;
        }
        return temp1;
    }

    /**
     * 2.快慢指针法
     * 两个链表是相交链表，那么将其中一个链表的头节点接在另一个链表的尾节点上，就会形成一个带环的链表
     * 带环的链表的环入口即为相交链表的第一个交点
     * 寻找带环链表的环入口最经典的方法就是使用快慢指针，即设置两个指针，慢指针一次移动一步，快指针一次移动两步，快指针和慢指针能相遇则说明该链表是带环链表。
     * 当快慢指针第一次相遇，慢指针一定还没走完一次环形。
     *
     * 关于环形入口：
     * 设带环链表的起点是到环入口是长度是p，环入口到快慢指针相遇的地方距离c，设慢指针走的距离是n
     * 则：n=p+c
     * 所以慢指针再走p步到达环形入口=带环链表头到环形入口的距离
     * 所以再用一个慢指针和当前慢指针同时走，相遇的节点则是环形入口
     * 环形入口即是相交链表的起始交点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // TODO
        return null;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        System.out.println();
    }
}
