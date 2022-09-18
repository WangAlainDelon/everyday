package leetcode.linkedlist.leetcode11_148;

import leetcode.linkedlist.common.CommonUtils;
import leetcode.linkedlist.common.ListNode;

public class SortListTest {

    /**
     * 上一个题用了插入排序 这个题我就用一下选择排序
     * 选择排序的思想：
     * 从数组中选择最小元素，将它与数组的第一个元素交换位置。再从数组剩下的元素中选择出最小的元素，
     * 将它与数组的第二个元素交换位置。不断进行这样的操作，直到将整个数组排序
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = {4, 2, 1, 3};
        //  4->2->1->3
        //dummyHead
        ListNode listNode = CommonUtils.getListNode(ints);
    }


    public static ListNode sortList2(ListNode head) {








        return null;
    }


    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode unSort = dummyHead;

        ListNode cur = head;
        ListNode re = dummyHead;
        ListNode minNode = head;


        while (cur != null) {
            ListNode startNode = unSort;
            //最小值的前驱节点
            ListNode pre = null;
            //最小值的后继节点
            ListNode next = null;

            //遍历链表找到最小的一个节点
            while (startNode != null) {
                if (startNode.next.val < minNode.val) {
                    minNode = startNode;
                    pre = startNode;
                    next = startNode.next.next;
                }
                startNode = startNode.next;
            }


            re.next = minNode;
            re = re.next;
//            cur = cur.next;
        }
        return dummyHead.next;
    }
}
