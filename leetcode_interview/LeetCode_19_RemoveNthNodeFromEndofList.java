package leetcode_interview;


//  Definition for singly-linked list.
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}

public class LeetCode_19_RemoveNthNodeFromEndofList {
    /**
     * 使用双指针方法
     * slow 和 fast指针都指向dummy指针
     * fast先移动n个位置，然后slow和fast一起移动
     * 最后删除slow指针的位置
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //防止fast指针越界
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        //移动fast指针
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //两个指针移动
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //删除slow对应的节点
        slow.next = slow.next.next;
        return dummy.next;
    }

}
