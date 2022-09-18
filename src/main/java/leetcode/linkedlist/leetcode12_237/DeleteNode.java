package leetcode.linkedlist.leetcode12_237;

import leetcode.linkedlist.common.CommonUtils;
import leetcode.linkedlist.common.ListNode;


public class DeleteNode {
    /**
     * 不给定头节点的情况下，删除单向链表的中的节点
     * 思路： s删除node  可以用下一个节点的值替换
     * 删除下一个节点不就好办了吗
     * <p>
     * 这儿要用到改节点的value
     *
     * @param args
     */

    public static void main(String[] args) {

        int[] ints = {4, 5, 1, 9};
        ListNode listNode = CommonUtils.getListNode(ints);
        ListNode listNode1 = deleteNode(listNode, 2);
        deleteNode(listNode.next, listNode);
    }


    public static void deleteNode(ListNode node, ListNode test) {

        node.val = node.next.val;  //这里要修改value的值  不讲武德
        node.next = node.next.next;
    }

    /**
     * 删除链表中的第n个元素
     *
     * @param listNode
     */
    public static ListNode deleteNode(ListNode head, int n) {


        ListNode pre = new ListNode(0);
        ListNode re = pre;
        pre.next = head;
        for (int i = 1; i <= n; i++) {
            if (i == n) {
                ListNode cur = head;
                ListNode next = cur.next;
                pre.next = next;
                break;
            } else {
                pre = pre.next;
                head = head.next;
            }
        }

        return re.next;
    }
}
