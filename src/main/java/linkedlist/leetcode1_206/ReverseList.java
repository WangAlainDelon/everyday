package linkedlist.leetcode1_206;


public class ReverseList {
    //给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode listNode = reverse(node1);
    }

    public static ListNode reverseList(ListNode head) {
        //一开始没有考虑到边界条件
        if (head == null) {
            return head;
        }
        //一开始没有想到设立三个虚拟节点来保存信息
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = head.next;
        //一开始没想到遍历链表怎么遍历
        //一开始的边界问题没有处理好  这里用cur.next  那么cur就必定要非空才行
        //到底用哪个条件判断非空  和代码的关系非常大
        while (next != null) {
            ListNode temp = cur;
            cur.next = pre;
            pre = temp;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
    }


    /**
     * 第二次写
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;

        //主要是要考虑好边界，如果用的条件是cur!=null ,那么最后cur必定是以null结尾
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    //第二种，以递归的方式进行反转

    /**
     * 我们之所以选择顺序遍历，然后反转链表是是因为我们无法像数组一样直接找到链表的最后一个元素
     * 但是递归可以帮我们把链表压入栈中，出栈的时候就是天然的最后一个元素，并且随着栈帧的弹出，将指针指向下一个弹出的元素即可
     * 返回第一个弹出的元素。
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        // if (head == null) 说明链表为 null
        // if (head.next == null) 说明此时的 head 节点为最后一个节点
        if (head == null || head.next == null) return head;
        // 遍历
        ListNode last = reverse (head.next);
        // 后序
        head.next.next = head;
        head.next = null;
        // 注意：永远返回的是最底层递归的结果。递归中途，返回值是没有改变的
        return last;
    }

}
