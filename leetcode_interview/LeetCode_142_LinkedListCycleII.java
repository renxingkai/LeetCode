package leetcode_interview;

public class LeetCode_142_LinkedListCycleII {

    /**
     * 快指针一次走两步，
     * 慢指针一次走一步
     * 第一次相遇后，让p指针指向head,
     * slow和p一起开始一步步走，相遇的节点就是第一个入环节点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        //仅有一个节点
        if (head.next == head) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            if (fast.next == null||fast.next.next == null ) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
    }
}
