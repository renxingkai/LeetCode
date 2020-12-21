package offer_I;

import java.util.List;

public class FindKthToTail {


    public ListNode FindKthToTail(ListNode head,int k) {
        //快指针先走K步
        if (head==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        for (int i=0;i<k;i++){
            if (fast!=null){
                fast=fast.next;
            }else {
                return null;
            }
        }
        //一起走
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }


}
