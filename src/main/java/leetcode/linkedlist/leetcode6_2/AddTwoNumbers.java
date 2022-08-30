package leetcode.linkedlist.leetcode6_2;

import leetcode.linkedlist.CommonUtils;
import leetcode.linkedlist.common.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbers {
    public static void main(String[] args) {

        int i = 15 % 10;

        int[] ints1 = {2, 4, 3};
        int[] ints = {5, 6, 4};
        ListNode listNode = CommonUtils.getListNode(ints);
        ListNode listNode1 = CommonUtils.getListNode(ints1);

        ListNode listNode2 = addTwoNumbers(listNode, listNode1);
    }


    /**
     * 思路  首先两个链表是倒序的， 021  120
     * 两个链表节点的值都是0到9的
     * 然后两个节点的值相加， 相加之后对大于10  就对10取余，那么就产生进位，否则产生一个新的节点
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode list1 = l1;
        ListNode list2 = l2;

        ListNode temp = new ListNode(0);
        ListNode re = temp;

        boolean flag = false;
        while (list1 != null || list2 != null ||flag) {
            int val1 = 0;
            int val2 = 0;
            if (list1 != null) {
                val1 = list1.val;
                list1 = list1.next;
            }
            if (list2 != null) {
                val2 = list2.val;
                list2 = list2.next;
            }
            if (flag) {
                val1++;
                flag = false;
            }
            if (val1 + val2 >= 10) {
                //  9+9+1
                int i = (val1 + val2) % 10;
                ListNode new1 = new ListNode(i);
                temp.next = new1;
                //  第一次赋值完要后移一个又忘了
                temp = temp.next;
                flag = true;
                //产生进位的1
            } else {
                //产生一个新节点
                ListNode listNode = new ListNode(val1 + val2);
                temp.next = listNode;
                temp = temp.next;
            }
        }

        return reverseList(re.next);
    }


    private static ListNode reverseList(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode pre = null;
        ListNode cur = node;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            //pre 后移
            pre = cur;
            //cur 后移
            cur = next;
        }
        return pre;
    }

    private static void printList() {

    }
}
