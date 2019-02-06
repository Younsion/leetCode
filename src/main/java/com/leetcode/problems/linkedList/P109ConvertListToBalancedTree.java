package com.leetcode.problems.linkedList;

/**
 * @author yongxing.chen
 * @date 2019-01-28 下午8:13
 */
public class P109ConvertListToBalancedTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode doubleNode = head;
        ListNode startNode = head;
        ListNode nodeLast = null;
        while (doubleNode != null && doubleNode.next != null) {
            nodeLast = head;
            head = head.next;
            doubleNode = doubleNode.next.next;
        }
        nodeLast.next = null;
        TreeNode treeNode = new TreeNode(head.val);
        treeNode.left = sortedListToBST(startNode);
        treeNode.right = sortedListToBST(head.next);
        return treeNode;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(-10);
        node.next = new ListNode(3);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(5);
        node.next.next.next.next = new ListNode(9);
        TreeNode treeNode = new P109ConvertListToBalancedTree().sortedListToBST(node);
        System.out.println(treeNode);
    }

}
