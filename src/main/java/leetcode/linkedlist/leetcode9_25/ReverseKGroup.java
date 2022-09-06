package leetcode.linkedlist.leetcode9_25;

import leetcode.linkedlist.CommonUtils;
import leetcode.linkedlist.common.ListNode;

public class ReverseKGroup {

    //K个一组翻转链表
    public static void main(String[] args) {

        int[] ints = {1, 2, 3, 4, 5};
        ListNode listNode = CommonUtils.getListNode(ints);
        ListNode listNode1 = reverseKGroup(listNode, 2);
    }


    //先不考虑O(1)的额外内存空间
    // 实现的思路: 首先还是循环链表，然后k个后截断,然后 反转链表， 返回来串起结束
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode re = new ListNode(0);
        ListNode tmp = re;
        while (head != null) {
            // 从链表开始获得k个元素 考虑当不够k个就是结束
            ListNode listNode = head;
            ListNode endNode = null;
            // 第一次的时候搞不清到底head应该滑动k次还是k-1次，如果滑动K-1次  那么奇数个节点的时候最后一个节点取不到
            for (int i = 0; i < k; i++) {
                if (head != null) {
                    head = head.next;
                } else {
                    endNode = listNode;
                }
            }
            //最后一段
            if (endNode != null) {
                tmp.next = endNode;
                return re.next;
            }
            //head 下移
//            head = head.next;
            //翻转这K个元素
            // 从listNode 这个位置开始反转链表
            ListNode pre = null;
            for (int i = 0; i < k; i++) {
                ListNode next = listNode.next;
                listNode.next = pre;
                pre = listNode;
                listNode = next;
            }
            tmp.next = pre;
            for (int i = 0; i < k; i++) {
                tmp = tmp.next;
            }
        }
        return re.next;
    }

}
