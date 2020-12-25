package offer_I;

import org.w3c.dom.css.CSSRuleList;

import java.util.List;

public class EntryNodeOfLoop {


    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null||pHead.next==null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }

}
