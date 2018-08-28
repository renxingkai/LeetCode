package cn.rxk;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_141 {

    public static void main(String[] arg) {

    }

    /**
     * 思路一:
     * 用Set来保存每个元素，如果set中已经含有，则表示列表有环，否则列表没有环
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }


    /**
     * 思路二:
     * 使用快慢指针，快指针一次走两步，慢指针一次走一步，如果快慢指针相同，则说明有环，并且快指针比慢指针多走了一个环的大小
     *
     * 遍历链表，一次快（每次获取后面第二个），一次慢（每次获取后面第一个）
     * 若快的节点为null或下一个为null，则不包含环
     * 在若干次之后，若快的节点与慢的节点相同则包含环。（此时快的遍历比慢的遍历领先了一个链表的长度）
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        if (head==null||head.next==null){
            //如果快指针或者慢指针到达了链表尾，则不存在环
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while (slow!=fast){
            if (fast==null||fast.next==null){
                //如果快指针或者慢指针到达了链表尾，则不存在环
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        //否则，如果快指针和慢指针出现的相等的状态，则说明有环
        return true;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}