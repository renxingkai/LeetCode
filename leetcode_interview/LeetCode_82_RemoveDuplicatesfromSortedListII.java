package leetcode_interview;

public class LeetCode_82_RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode preNode = dummy;
        ListNode realNode = dummy;
        ListNode curNode = head;
        while (curNode != null) {
            if ((preNode == dummy || preNode.val != curNode.val) &&
                    (curNode.next == null || curNode.val
                    != curNode.next.val)) {
                realNode.next = curNode;
                realNode = curNode;
            }
            preNode = curNode;
            curNode = curNode.next;
            //preNode和curNode之间并没有指针相连
            preNode.next = null;
        }
        return dummy.next;
    }
}
