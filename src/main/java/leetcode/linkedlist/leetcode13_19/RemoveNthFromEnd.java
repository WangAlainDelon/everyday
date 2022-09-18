package leetcode.linkedlist.leetcode13_19;

import leetcode.linkedlist.common.CommonUtils;
import leetcode.linkedlist.common.ListNode;

public class RemoveNthFromEnd {

    /**
     * 删除链表的倒数第N个节点
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] ints = {1, 2};
        ListNode listNode = CommonUtils.getListNode(ints);
        ListNode listNode1 = removeNthFromEnd(listNode, 1);

    }

    /**
     * 我第一次想到的方式是这样的
     * 先反转链表，然后删除第N个节点
     * 再反转链表返回
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        if (head.next == null && n == 1) {
            return null;
        }
        //反转链表返回尾部
        ListNode reverseNode = reverseNode(head);
        ListNode pre = new ListNode(0);
        pre.next = reverseNode;
        ListNode re = pre;
        //反转链表后删除第N个元素
        for (int i = 1; i <= n; i++) {
            if (i == n) {
                ListNode cur = reverseNode;
                ListNode next = cur.next;
                pre.next = next;
            } else {
                pre = pre.next;
                reverseNode = reverseNode.next;
            }
        }
        // 然后再反转链表返回
        ListNode listNode = reverseNode(re.next);
        return listNode;
    }

    private static ListNode reverseNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    //模式识别： 一旦需要定位链表中的特定位置，可以使用快慢指针，以不同的速度遍历该链表
    //  涉及链表的特定位置  考虑快慢指针   一旦要删除节点  需要找到节点的前驱
    // => 用快慢指针法找到倒数第n+1个节点 并且删除其后继节点
    // 删除倒数第n个节点就是让快指针先走n+1步，这个时候慢指针再开始走
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);  // 虚拟头节点可以方便删除第一个节点
        dummyHead.next = head;
        ListNode first = dummyHead;
        ListNode second = dummyHead;

        //先指针走n+1不
        while (n >= 0) {
            first = first.next;
            n--;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyHead.next;
    }


}
