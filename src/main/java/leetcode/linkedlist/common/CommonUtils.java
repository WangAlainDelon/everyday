package leetcode.linkedlist.common;

import leetcode.linkedlist.common.ListNode;

public class CommonUtils {

    public static ListNode getListNode(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode node = new ListNode(0);
        ListNode re = node;
//        for (int i = 0; i < array.length; i++) {
//            ListNode listNode = new ListNode(array[i]);
//            node.next = listNode;
//        }
        for (int i : array) {
            ListNode listNode = new ListNode(i);
            node.next = listNode;
            node = node.next;
        }
        return re.next;

    }
}
