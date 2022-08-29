package leetcode.linkedlist.leetcode3_83;

public class DeleteDuplicates {

    /**
     * 删除链表中重复的元素
     */

    public static void main(String[] args) {




    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        //如果当前节点的值和下一个节点的值一样，则当前节点的next直接指向next.next
        // 知道没有断指针 cur才向下滑动一个
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                break;
            }
            if (cur.val == next.val) {
                cur.next = next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
