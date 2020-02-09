package loadoffer;


//https://www.cnblogs.com/q-1993/p/10545904.html
public class ReverseList {
    public static void main(String[] args) {

    }

    public ListNode ReverseList(ListNode head) {
        ListNode qHead=null;//转换后的头节点
        if (head==null||head.next==null){
            return head;
        }
        ListNode p=head;
        while (p!=null){
            ListNode nextNode=p.next;
            p.next=qHead;
            qHead=p;
            p=nextNode;
        }
        return qHead;
    }

}
