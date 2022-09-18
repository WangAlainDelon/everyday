package leetcode.linkedlist.leetcode14_61;

import leetcode.linkedlist.common.ListNode;

public class RotateRight {


    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     *
     * @param args
     */
    public static void main(String[] args) {



    }

    /**
     * 暴力解法
     * 遍历链表  把链表圈成环  找到元素的个数n
     * 如果n%k-1个元素就是新链表的头
     * 然后遍历到尾部解开链表返回即可
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        //1.遍历链表 把链表圈成环  找到元素的个数n
        int n = 1;
        ListNode originHead = head;
        while (head.next != null) {
            head = head.next;
            n++;
        }
        head.next = originHead;

        // 如果n%k 为右移的个数
        int newK = 0;
        if (n > k) {
            newK = n % k;
        } else {
            newK = k % n;
        }
        // 新头节点的位置
        int newHeadState = n - newK;

        while (newHeadState > 0) {
            originHead = originHead.next;
            newHeadState--;
        }
        //从头开始找到尾部 解开尾部
        ListNode re = originHead;
        while (n > 0) {
            originHead = originHead.next;
            n--;
        }
        originHead.next = null;

        return re;

    }
}
