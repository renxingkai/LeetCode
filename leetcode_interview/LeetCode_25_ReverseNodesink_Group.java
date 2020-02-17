package leetcode_interview;

import java.util.Stack;

public class LeetCode_25_ReverseNodesink_Group {


    /**
     * 用栈的方式
     * 使用了额外空间，并不满足Leetcode要求
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        ListNode next = dummy.next;//使用next指针记录 入栈后的一个元素，以便于指出来
        while (next != null) {
            for (int i = 0; i < k && next != null; i++) {
                //往栈中push
                stack.push(next);
                next = next.next;
            }
            if (stack.size() != k) {
                return dummy.next;
            }
            //反着弹出
            while (stack.size() != 0) {
                current.next = stack.pop();
                current = current.next;
            }
            //最终要把之前未入栈的元素连上去
            current.next = next;
        }
        return dummy.next;
    }


    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev != null) {
            prev = reverse(prev, k);
        }
        return dummy.next;


    }

    private ListNode reverse(ListNode prev, int k) {
        //last要往后移动k个
        ListNode last = prev;
        for (int i = 0; i < k + 1; i++) {
            last = last.next;
            //不够k个元素
            if (i != k && last == null) {
                return null;
            }
        }
        //指向要旋转的首元素，它将变成转换过后的末尾元素
        //dummy-->1-->2-->3-->4-->5
        //tail:1
        //curr:2
        //prev:dummy
        //dummy-->3-->2-->1-->4-->5
        ListNode tail = prev.next;
        //从第二个node开始
        ListNode curr = prev.next.next;
        while (curr != last) {
            //进行交换
            ListNode next = curr.next;//next :3
            curr.next = prev.next;//2指向1
            prev.next = curr;//dummy指向2   暂时变成dummy-->2--1-->(一次处理两个元素) 然后继续添加末尾
            tail.next = next;//1的next指向3 dummy-->2--1-->3
            curr = next;//curr指向3的位置 开始去处理3
        }
        return tail;


    }


}
