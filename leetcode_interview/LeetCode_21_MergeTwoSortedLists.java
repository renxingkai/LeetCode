package leetcode_interview;

public class LeetCode_21_MergeTwoSortedLists {

    /**
     * 使用指针一个个节点往后指
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            //判断l1和l2哪个值大
            boolean flag = (l1.val < l2.val);
            //移动cur指针  l1小指向l1,否则指向l2
            cur.next = flag ? l1 : l2;
            cur = cur.next;
            //l1小要移动
            l1 = flag ? l1.next : l1;
            l2 = flag ? l2 : l2.next;
        }
        //谁先结束，指向另外一个
        cur.next = (l1 == null) ? l2 : l1;
        return head.next;
    }

}
