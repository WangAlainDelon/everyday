package leetcode.linkedlist.leetcode16_143;

import leetcode.linkedlist.common.CommonUtils;
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
        int[] ints = {1, 2, 3, 4};
        ListNode listNode = CommonUtils.getListNode(ints);
        ListNode listNode1 = reorderList(listNode);
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
        ListNode secondNode = origin;
        for (int i = 0; i < end; i++) {  //考虑奇数 偶数
            if (flag && i == (end - 1)) {
                ListNode mid = cur.next;
                secondNode.next = mid;
                mid.next = null;
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
            while (secondN > 1) {
                secondNode = secondNode.next;
                secondN--;
            }
            //两两组合
            if (!flag && i == (end - 1)) {
                secondNode.next = null;
            }
            firstNode.next = secondNode;
            cur = cur.next;   // 我的第一种方法 走到这里来就行不通了，因为前面使用firstNode.next = secondNode 把链表的指向已经改了  这里取下一个元素娶不到了
        }
        return re;
    }

    //题解1 采用线性表来装链表的节点，这样可以通过下标访问到链表的节点，然后就好办了

    //题解2： 寻找链表中点 + 链表逆序 + 合并链表
    // 参考「876. 链表的中间结点」）。我们可以使用快慢指针来 O(N)O(N) 地找到链表的中间节点。
    // 然后将右半边链表反转， 然后合并两个链表  合并是左1->右1->左2->右2....->中间节点




}
