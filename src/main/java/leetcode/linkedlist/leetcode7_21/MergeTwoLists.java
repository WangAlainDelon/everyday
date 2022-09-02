package leetcode.linkedlist.leetcode7_21;

import leetcode.linkedlist.common.ListNode;

public class MergeTwoLists {


    //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    public static void main(String[] args) {


    }

    /**
     * 合并两个有序链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //同时遍历两个链表，对比大小找到新节点
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode re = new ListNode(0);
        ListNode temp = re;
        while (list1 != null || list2 != null) {
            ListNode val1 = null;
            ListNode val2 = null;
            if (list1 != null) {
                val1 = list1;
            }
            if (list2 != null) {
                val2 = list2;
            }
            ListNode newNode = null;
            if (val1 == null && val2 != null) {
                newNode = val2;
                list2 = list2.next;
            } else if (val1 != null && val2 == null) {
                newNode = val1;
                list1 = list1.next;
            } else {
                // 在这里才把节点往下移动
                if (val1.val > val2.val) {
                    newNode = val2;
                    list2 = list2.next;
                } else {
                    newNode = val1;
                    list1 = list1.next;
                }
            }
            temp.next = newNode;
            temp = temp.next; //第一次没有注意到结果的链表还是要跟着向下移动
        }
        return re.next;
    }
}
