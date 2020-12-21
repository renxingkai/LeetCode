package offer_I;

import java.util.ArrayList;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class PrintListFromTailToHead {


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }
        ListNode dummy=null;
        ListNode cur=listNode;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=dummy;
            dummy=cur;
            cur=temp;
        }
        while (dummy!=null){
            res.add(dummy.val);
            dummy=dummy.next;
        }
        return res;
    }


}
