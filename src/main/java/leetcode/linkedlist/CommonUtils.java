package leetcode.linkedlist;

import leetcode.linkedlist.common.ListNode;

public class CommonUtils {

    public static ListNode getListNode(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode node = new ListNode(0);
        ListNode re = node;
        for (int i : array) {
            ListNode listNode = new ListNode(array[i]);
            node.next = listNode;
        }
        return re.next;

    }
}
