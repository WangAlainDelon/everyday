package leetcode.linkedlist.leetcode10_147;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import leetcode.linkedlist.CommonUtils;
import leetcode.linkedlist.common.ListNode;

public class InsertionSortList {

    // 对一个链表用插入排序的方法进行排序
    public static void main(String[] args) {
        int[] ints = {4,2,1,3};
        ListNode listNode = CommonUtils.getListNode(ints);
        ListNode listNode1 = insertionSortList(listNode);
    }

    /**
     * 需要定义排好序元素的最后一个，和当前一个
     *
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 设置虚拟头节点的原因就是为了可以往head的前面插入元素
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head.next;
        ListNode lastSorted = head;

        while (cur != null) {
            if (lastSorted.val <= cur.val) {
                lastSorted = lastSorted.next;
                cur = cur.next;
            } else {
                //遍历排好序的链表  找到合适的位置插入 设置虚拟头节点的原因就是为了可以往head的前面插入元素
                ListNode pre = dummyHead;
                //这儿要注意移动的位置 pre.next.val才能找到pre
                while (pre.next.val <= cur.val) {
                    pre = pre.next;
                }
                ListNode next = cur.next;
                ListNode preNext = pre.next;

                pre.next = cur;
                cur.next = preNext;

                lastSorted.next = next;
                cur = next;
            }
        }


        return dummyHead.next;
    }


    public ListNode insertionSortList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head;
        ListNode curr = head.next;
        while (curr != null) {
            //如果不需要移动元素，最后一个排好序的元素往后移动，当前元素往后移动
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                // 这里当当前节点的值小于前一个节点的值的时候，就要从节点的起始位置开始找到合适的插入位置
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                //还可以这样
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }


}
