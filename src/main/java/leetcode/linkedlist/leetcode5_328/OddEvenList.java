package leetcode.linkedlist.leetcode5_328;

import leetcode.linkedlist.CommonUtils;
import leetcode.linkedlist.common.ListNode;

public class OddEvenList {

    /**
     * 将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数
     * <p>
     * 就是将第1，3，5，7...个元素组合，再将2，4，6，8...个元素组合
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6};
        ListNode listNode = CommonUtils.getListNode(ints);
        oddEvenList(listNode);
    }

    /**
     * 解决这类题目的关键就是 分割链表  虚拟节点  组合技巧
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode re = left;
        ListNode rightHead = right;
        boolean flag = true;
        while (head != null) {
            if (flag) {
                left.next = head;
                left = left.next;
                flag = false;
            } else {
                right.next = head;
                right = right.next;
                flag = true;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightHead.next;
        return re.next;
    }
}
