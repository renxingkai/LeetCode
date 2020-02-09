package leetcode;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        if (l1 == null && l2 == null) {
            return l1;
        }
        back(node, l1, l2);
        return node;
    }

    private void back(ListNode node, ListNode l1, ListNode l2) {
        if (l1 != null) {
            node.val += l1.val;
        } else {
            l1 = new ListNode(0);
        }
        if (l2 != null) {
            node.val += l2.val;
        } else {
            l2 = new ListNode(0);
        }

        ListNode node1 = new ListNode(0);
        if (node.val >= 10) {
            node.val = node.val % 10;
            node1.val = 1;
            node.next = node1;
        }
        if (l1.next != null || l2.next != null) {
            node.next = node1;
            back(node.next, l1.next, l2.next);
        }
    }

}
