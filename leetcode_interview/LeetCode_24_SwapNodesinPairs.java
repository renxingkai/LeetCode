package leetcode_interview;

public class LeetCode_24_SwapNodesinPairs {
    /**
     * 交换前后指针，主要考察指针操作
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode current=dummy;
        //current.next保证偶数个
        //current.next保证奇数个
        while (current.next!=null&&current.next.next!=null){
            swap2(current);
            //要一次跳两个，因为其实是在操作3个节点current,current.next,current.next.next
            current=current.next.next;
        }
        return dummy.next;

    }
    //      1-->2-->3-->4-->5
    //交换完 1-->2-->4-->3-->5
    //current为1
    private void swap2(ListNode current) {
        //current 2
        ListNode dummy=current.next;//dummy 3
        current.next=dummy.next;//2-->4
        dummy.next=dummy.next.next;//3-->4
        current.next.next=dummy;        //4-->3
    }
}