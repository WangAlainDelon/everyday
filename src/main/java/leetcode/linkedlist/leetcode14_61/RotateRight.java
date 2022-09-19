package leetcode.linkedlist.leetcode14_61;

import leetcode.linkedlist.common.CommonUtils;
import leetcode.linkedlist.common.ListNode;

public class RotateRight {


    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] ints = {0, 1, 2};
        ListNode listNode = CommonUtils.getListNode(ints);
        ListNode listNode1 = rotateRight(listNode, 0);


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
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        //1.遍历链表 把链表圈成环  找到元素的个数n
        int n = 1;
        ListNode originHead = head;
        while (head.next != null) {
            head = head.next;
            n++;
        }

        // n%k 为右移的个数
        int newK = 0;
        if (n >= k) {
            newK = k;
        } else {
            newK = k % n; //一开始大于k>n的情况考虑不周全
        }
        head.next = originHead;
        // 新头节点的位置 第newHeadState个元素就是新的头节点
        int newHeadState = n - newK + 1;

        while (newHeadState > 1) {     //第一次没有注意到这里是要>1  一开始写的>0
            originHead = originHead.next;
            newHeadState--;
        }
        //从头开始找到尾部 解开尾部
        ListNode re = originHead;
        while (n > 1) {  //第一次没有注意到这里是要>1  一开始写的>0
            originHead = originHead.next;
            n--;
        }
        originHead.next = null;

        return re;

    }
}
