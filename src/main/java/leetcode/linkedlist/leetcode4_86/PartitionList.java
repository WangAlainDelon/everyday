package leetcode.linkedlist.leetcode4_86;

import leetcode.linkedlist.common.CommonUtils;
import leetcode.linkedlist.common.ListNode;

public class PartitionList {

    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * <p>
     * 你应当 保留 两个分区中每个节点的初始相对位置。  这个题目最主要的是要保证他的相对位置
     */
    public static void main(String[] args) {
        //[1,4,3,2,5,2], x = 3
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        // 1->4->3->2->5->2
        // 1->2->2->4->3->5
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode listNode = CommonUtils.getListNode(new int[]{1, 1});

        ListNode partition = partition(listNode, 0);

    }


    /**
     * 第一次
     * 思路：就是弄两个链表，小于x的放左边 大于等于x的放右边  然后将两个链表组合即可
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        //遍历链表，值小于的就放左边链表
        // 第一次做的时候，虚拟节点不知道怎么弄，直接给了一个null 造成了很大的麻烦
        ListNode leftList = null;
        ListNode rightList = null;
        ListNode rightListHead = null;
        ListNode cur = head;
        ListNode re = null;
        while (cur != null) {
            if (cur.val < x) {
                if (leftList == null) {
                    leftList = cur;
                    re = leftList;
                } else {
                    leftList.next = cur;
                    leftList = leftList.next;
                }
            } else {
                if (rightList == null) {
                    rightList = cur;
                    rightListHead = rightList;
                } else {
                    rightList.next = cur;
                    rightList = rightList.next;
                }
            }
            cur = cur.next;
        }
        //组合左右两个链表  组装的时候要特别小心，一定要吧尾巴截断
        if (leftList != null) {
            if (rightListHead != null) {
                rightList.next = null;
            }
            leftList.next = rightListHead;
            return re;
        } else {
            return rightListHead;
        }
    }

    /**
     * 第二次做  我们用虚拟节点
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition2(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode leftList = new ListNode(0);
        ListNode rightList = new ListNode(0);
        ListNode rightListHead = rightList;
        ListNode reListNode = leftList;
        while (head != null) {
            if (head.val < x) {
                leftList.next = head;
                leftList = leftList.next;
            } else {
                rightList.next = head;
                rightList = rightList.next;
            }
            head = head.next;
        }
        rightList.next = null;
        leftList.next = rightListHead.next;
        return reListNode.next;
    }


    /**
     * 题解
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition3(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

}
