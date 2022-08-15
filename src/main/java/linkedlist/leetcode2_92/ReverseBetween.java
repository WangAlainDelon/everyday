package linkedlist.leetcode2_92;

import java.util.List;

public class ReverseBetween {

    //反转指定区间的链表
    // 汲取上一道题目的教训，处理好边界问题

    //我的思路是可以利用好第一个题目，把需要反转的链表找出来，然后让第一个题目将他反转好了之后再组装


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode node = reverseBetween(node1, 2, 4);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null) {
            return head;
        }
        if (right - left <= 0) {
            return head;
        }

        // 找到startNode和endNode
        ListNode cur = head;
        int count = 1;
        ListNode startNode = null;
        ListNode endNode = null;
        while (cur != null) {
            if (count == left - 1) {
                startNode = cur;  // node 2
            }
            if (count == right) {
                endNode = cur.next; //node 5
            }
            count++;
            cur = cur.next;
        }

        //截取指定范围内的链表   截断链表之后应该是三条链表
        ListNode listNode = subListNode(head, left, right);
        //反转子链表
        ListNode node = reverseList(listNode);


        //把截断的链表拼接起来
        startNode.next = node;
        while (node != null) {
            if (node.next == null) {
                node.next = endNode;
                break;
            }
            node = node.next;
        }
        return head;
    }

    private static ListNode subListNode(ListNode head, int left, int right) {
        int count = 0;
        ListNode cur = head;
        ListNode startNode = null;
        while (cur != null) {
            count++;
            if (count == left) {
                startNode = cur;
            }
            if (count == right) {
                cur.next = null;
                return startNode;
            }
            cur = cur.next;
        }
        return startNode;

    }

    private static ListNode reverseList(ListNode startNode) {
        //多次写到这里还要出错
        ListNode cur = startNode;
        ListNode pre = null;
        while (cur != null) {
            //1.保存值 保存改变指针时指向的这个值
            ListNode next = cur.next;
            //2.赋值逆转指针的指向
            cur.next = pre;
            //3.移动游标
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
