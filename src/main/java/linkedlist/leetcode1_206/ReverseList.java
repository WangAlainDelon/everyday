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

        ListNode listNode = reverseList(node1);
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

}
