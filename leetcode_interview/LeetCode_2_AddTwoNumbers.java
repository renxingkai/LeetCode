package leetcode_interview;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class LeetCode_2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode head = new ListNode(0);
        ListNode l3 = head;//指向head节点
        int carry = 0;//进位
        while (node1 != null | node2 != null) {
            //l1的值
            int val1 = (node1 != null) ? node1.val : 0;
            //l2的值
            int val2 = (node2 != null) ? node2.val : 0;
            //切记 从低位算
            int sum = val1 + val2 + carry;
            carry = sum / 10;//取出进制
            int lastDigit = sum % 10;//余数 就是val1 + val2的个位数
            ListNode newNode = new ListNode(lastDigit);
            l3.next = newNode;

            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
            l3 = l3.next;
        }
        if (carry > 0) {
            //若存在进位，要把进位也链接上去
            ListNode newNode = new ListNode(carry);
            l3.next = newNode;
        }
//        head刚开始指向0，需要移向下一位
        return head.next;
    }
}
