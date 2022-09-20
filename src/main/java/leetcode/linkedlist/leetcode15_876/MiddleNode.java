package leetcode.linkedlist.leetcode15_876;

import leetcode.linkedlist.common.ListNode;

public class MiddleNode {

    //找到链表的中间节点
    public static void main(String[] args) {

    }

    // 快慢指针法找到链表的中间节点
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head;
        int n = 0;
        while (secondNode != null) {
            secondNode = secondNode.next;
            n++;
        }
        n = n / 2 + 1;
        while (n > 1) {
            firstNode = firstNode.next;
            n--;
        }
        return firstNode;
    }

}
