package offer_I;

public class DeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode cur = dummy.next;
        ListNode pre = dummy;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                //遇到重复的情况
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                //不是重复的情况
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }


    public static void main(String[] args) {

    }

}
