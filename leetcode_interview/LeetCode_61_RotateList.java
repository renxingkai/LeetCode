package leetcode_interview;

public class LeetCode_61_RotateList {
    /**
     * 双指针做法
     * 快指针先走k
     * 然后快慢指针一起走，直到快指针到null
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        int len = 0;
        //计算链表的长度
        while (fast != null) {
            len++;
            fast = fast.next;
        }
        fast = head;
        //先走fast指针
        for (int i = 0; i < k % len; i++) {
            fast = fast.next;
        }
        //fast和slow一起走
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //1->2->3->4->5
        //4->5->1->2->3
        fast.next = head;//5->1
        head = slow.next;//head->4
        slow.next = null;//3->null
        return head;
    }

}
