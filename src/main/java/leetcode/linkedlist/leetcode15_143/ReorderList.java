package leetcode.linkedlist.leetcode15_143;

import leetcode.linkedlist.common.ListNode;

public class ReorderList {

    /**
     * 重拍链表
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * @param args
     */

    public static void main(String[] args) {

        ListNode node1 = new ListNode(0);
        ListNode node2 = node1;
        System.out.println(node1 == node2);
    }

    //双指针的思路吧

    /**
     * 首先 第一个元素要和第n个元素组队
     * 地二个元素要和第n-1个元素组队
     * 如果是奇数个元素  就把最中间的元素放到最后
     */
    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode re = head;
        ListNode origin = head;
        int n = 0;  // n为元素的个数
        while (head != null) {
            head = head.next;
            n++;
        }
        ListNode cur = origin;
        int end = n / 2;
        boolean flag = false;
        if (n % 2 != 0) {
            flag = true;
            end++;
        }
        ListNode secondNode = null;
        for (int i = 0; i < end; i++) {  //考虑奇数 偶数
            if (flag && i == (end - 1)) {
                ListNode mid = cur.next;
                secondNode.next = mid;
                mid.next = null;
            } else {
                break;
            }

            ListNode firstNode = cur;
            // 计算firstNode
            while (i > 0) {
                firstNode = firstNode.next;
                i--;
            }
            // 计算secondNode
            int secondN = n - i;
            while (secondN > 0) {
                secondNode = secondNode.next;
            }
            //两两组合
            if (!flag && i == (end - 1)) {
                secondNode.next = null;
            }
            firstNode.next = secondNode;
            cur = cur.next;
        }

        return re;

    }
}
