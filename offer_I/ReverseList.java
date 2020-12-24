package offer_I;

public class ReverseList {

    public ListNode ReverseList(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode dummy=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=dummy;
            dummy=cur;
            cur=temp;
        }
        return dummy;
    }

    public static void main(String[] args) {

    }

}
