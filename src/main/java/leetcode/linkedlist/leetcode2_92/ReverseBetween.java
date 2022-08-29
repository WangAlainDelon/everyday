package leetcode.linkedlist.leetcode2_92;

import leetcode.linkedlist.common.ListNode;

public class ReverseBetween {

    //  反转指定区间的链表
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

        //[1,2,3]  1,2

//        ListNode node1 = new ListNode(3);
//        ListNode node2 = new ListNode(5);
//        node1.next = node2;

        ListNode node = reverseBetween(node1, 1, 2);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        //1.参数校验
        if (head == null) {
            return head;
        }
        if (right - left <= 0) {
            return head;
        }
        //2.找到要反转链表的位置
        //找到startNode和endNode   一开始没有考虑到反转链表的边界
        //startNode 为要反转链表的前一个节点
        //endNode 为要反转链表的后一个节点
        ListNode cur = head;
        int count = 1;
        ListNode startNode = null;
        ListNode endNode = null;
        while (cur != null) {
            if (count == left - 1) {
                startNode = cur;  // node 1
            }
            if (count == right + 1) {
                endNode = cur; //node 5
            }
            count++;
            cur = cur.next;
        }

        //3.截取指定范围内的链表
        ListNode listNode = subListNode(head, left, right);
        //4.反转子链表
        ListNode node = reverseList(listNode);

        //5.把截断的链表拼接起来
        if (startNode == null && endNode == null) {
            return node;
        }
        if (startNode != null && endNode != null) {
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
        if (startNode != null) {
            startNode.next = node;
            return head;
        } else {
            ListNode cur2 = node;
            while (cur2 != null) {
                if (cur2.next == null) {
                    cur2.next = endNode;
                    return node;
                }
                cur2 = cur2.next;
            }
            return node;
        }
    }

    private static ListNode subListNode(ListNode head, int left, int right) {
        int count = 1;
        ListNode cur = head;
        ListNode startNode = null;
        while (cur != null) {
            if (count == left) {
                startNode = cur;
            }
            if (count == right) {
                cur.next = null;
                return startNode;
            }
            cur = cur.next;
            count++;
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
