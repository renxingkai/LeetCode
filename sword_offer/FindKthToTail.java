package loadoffer;

public class FindKthToTail {

    public static void main(String[] args) {

    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null||k<=0){
            return null;
        }
        //遍历链表长度
        int n=0;
        ListNode tempNode=head;
        while (tempNode!=null){
            n++;
            tempNode=tempNode.next;
        }
        if (k>n){
            return null;
        }
        //遍历n-k+1个节点
        for (int i=0;i<n-k;i++){
            head=head.next;
        }
        return head;
    }

}
