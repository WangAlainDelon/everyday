package leetcode.linkedlist.leetcode8_24;

import leetcode.linkedlist.common.ListNode;

public class SwapPairs {

    //给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
    public static void main(String[] args) {

    }


    //首先肯定是两个一组  把两个元素看成一组，然后内部交换 一次下移两个元素
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode listNode = new ListNode(0);
        ListNode re = listNode;
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            head = head.next.next; // 第一次没有考虑到这个应该放在前面  不然要null
            ListNode tmp = swap(firstNode, secondNode);
            listNode.next = tmp;
//            head = head.next.next;
            listNode = listNode.next.next;
        }
        //第一次没有考虑到 单数个数的元素
        if (head != null) {
            listNode.next = head;
        }
        return re.next;
    }

    private ListNode swap(ListNode firstNode, ListNode secondNode) {
        if (secondNode == null) {
            return firstNode;
        } else {
            secondNode.next = firstNode;
            firstNode.next = null; //第一次没有考虑到这里要断掉  不然产生循环了
        }
        return secondNode;
    }
}
