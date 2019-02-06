package com.leetcode.problems.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * @author yongxing.chen
 * @date 2019-01-29 下午8:09
 */
public class P138CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode node = head;
        RandomListNode newNode = newHead;
        Map<RandomListNode, RandomListNode> oldToNewMap = new HashMap<RandomListNode, RandomListNode>();
        oldToNewMap.put(node, newNode);
        while (node != null) {
            RandomListNode mappingNextNode = oldToNewMap.get(node.next);
            if (node.next != null) {
                if (mappingNextNode == null) {
                    newNode.next = new RandomListNode(node.next.label);
                    oldToNewMap.put(node.next, newNode.next);
                } else {
                    newNode.next = mappingNextNode;
                }
            }
            if (node.random != null) {
                RandomListNode mappingRandomNode = oldToNewMap.get(node.random);
                if (mappingRandomNode == null) {
                    newNode.random = new RandomListNode(node.random.label);
                    oldToNewMap.put(node.random, newNode.random);
                } else {
                    newNode.random = mappingRandomNode;
                }
            }
            node = node.next;
            newNode = newNode.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(1);
        node.next = new RandomListNode(2);
        node.next.next = new RandomListNode(3);
        node.next.next.next = new RandomListNode(4);
        node.next.next.next.next = new RandomListNode(5);
        node.random = node.next.next;
        node.next.random = node.next.next.next;
        node.next.next.next.random = node.next.next.next.next;
        node.next.next.next.next.random = node;
        RandomListNode node1 = new P138CopyListWithRandomPointer().copyRandomList(node);
        System.out.println(node1);
    }
}
