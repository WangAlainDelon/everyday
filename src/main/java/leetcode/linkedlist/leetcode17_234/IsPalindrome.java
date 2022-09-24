package leetcode.linkedlist.leetcode17_234;

import com.sun.org.apache.bcel.internal.generic.DUP;
import leetcode.linkedlist.common.ListNode;

public class IsPalindrome {

    // 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
    // 回文就是正的跟反的读都是一样的
    // 如果是字符或者数组都好办，可以利用指针碰撞的方式来判断是不是回文
    public static void main(String[] args) {

    }


    // 思路：快慢指针的方式
    // 1.中分链表  反转一半  然后再两个指针判断
    public boolean isPalindrome(ListNode head) {
        if (head == null && head.next == null) {
            return true;
        }
        ListNode midNode = getMidNode(head);

        ListNode node = getReverse(midNode);

        while (head != null) {
            if (head.val != node.val) {
                return false;
            }
            head = head.next;
            node = node.next;
        }
        return true;
    }

    private ListNode getReverse(ListNode midNode) {
        ListNode pre = null;
        while (midNode != null) {
            ListNode next = midNode.next;
            midNode.next = pre;
            pre = midNode;
            midNode = next;
        }
        return pre;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode firstNode = head;
        ListNode secondNode = head;
        int n = 0;
        while (firstNode != null) {
            firstNode = firstNode.next;
            n++;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = secondNode;
        int mid = n / 2;
        while (mid > 0) {
            secondNode = secondNode.next;
            dummyHead = dummyHead.next;
            mid--;
        }
        dummyHead.next = null;
        return secondNode;
    }
}
