package leetcode_interview;

public class LeetCode_86_PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        //使用三个指针
        ListNode left = dummy;
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        while (curr != null) {
            if (prev == left) {
                //curr之前的值 等于left值
                if (curr.val < x) {
                    //当前值比x小，需要放到x左边
                    //此时直接移动curr指针就行
                    left = left.next;
                }
                prev = curr;
                curr = curr.next;
            } else {
                //left不等于prev
                if (curr.val >= x) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    //等于的情况？
                    //移动当前curr,插入到left下一个
                    prev.next = curr.next;
                    curr.next = left.next;
                    left.next = curr;
                    left = left.next;
                    curr = prev.next;
                }

            }
        }
        return dummy.next;
    }
}
