//import java.util.LinkedList;
//import java.util.Queue;
//
//public class LeetCode_876 {
//
//    public static void main(String[] arg) {
//
//    }
//
//    /**
//     * 思路一：
//     *      采用队列，每次将val入队，然后返回队列后一半元素
//     * @param head
//     * @return
//     */
//    public static ListNode middleNode(ListNode head) {
//
//        Queue<ListNode> queue=new LinkedList<>();
//        //不断循环，看head是否到队列尾
//        while (head!=null){
//            //对元素进行入队
//            queue.offer(head);
//            //head指向下一个节点
//            head=head.next;
//        }
//
//        int size=queue.size();
//        //对前1/2出队
//        for (int i=0;i<size/2;i++){
//            queue.poll();
//        }
//        //返回队列后1/2
//        return queue.peek();
//
//    }
//
//
//
//    /**
//     * 思路二：
//     *      使用两个“指针”，一个快指针一次走两步，慢指针一次走一步，快指针走完列表，慢指针即走到了1/2位置
//     * @param head
//     * @return
//     */
//    public static ListNode middleNode1(ListNode head) {
//
//       ListNode slow=head;
//       ListNode fast=head;
//        //快指针一次走两步，慢指针一次走一步
//       while (fast!=null&&fast.next!=null){
//           slow=slow.next;
//           fast=fast.next.next;
//       }
//       return slow;
//
//    }
//
//}
//
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}