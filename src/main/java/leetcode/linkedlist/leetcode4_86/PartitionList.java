package leetcode.linkedlist.leetcode4_86;

public class PartitionList {

    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * <p>
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     */
    public static void main(String[] args) {
        //[1,4,3,2,5,2], x = 3
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode partition = partition(node1, 3);

    }


    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        //遍历链表，值小于的就放左边链表
        ListNode leftList = null;
        ListNode rightList = null;
        ListNode rightListHead = null;
        ListNode cur = head;
        ListNode re = null;
        while (cur != null) {
            if (cur.val < x) {
                if (leftList == null) {
                    leftList = cur;
                    re = cur;
                } else {
                    leftList.next = cur;
                    leftList = leftList.next;
                }
            } else {
                if (rightList == null) {
                    rightList = cur;
                    rightListHead = cur;
                } else {
                    rightList.next = cur;
                    rightList = rightList.next;
                }
            }
            cur = cur.next;
        }
        //组合左右两个链表
        if (leftList != null) {
            leftList.next = rightListHead;
            return re;
        } else {
            return rightList;
        }
    }
}
