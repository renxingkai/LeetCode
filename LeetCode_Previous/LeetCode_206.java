/*
参考链接:https://blog.csdn.net/SoulOH/article/details/81062223
 */
public class LeetCode_206 {
    //迭代方法
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        p1.next = null;//将p1的下一指针设为null
        while (p2 != null) {
            ListNode tmp = p2.next;//指向p2下一个节点
            p2.next = p1;//p2反向指p1
            p1 = p2;//移动p1和p2
            p2 = tmp;//p2移动下下一个节点
        }
        return p1;
    }
    //递归方法
    public ListNode reverseList1(ListNode head) {
        if (head == null||head.next==null) {
            return head;
        }
        ListNode subListHead=reverseList1(head.next);
        head.next.next=head;
        head.next=null;
        return subListHead;
    }

    public static void main(String[] arg) {

    }
}


//Definition for singly-linked list.
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}
