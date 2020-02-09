package leetcode;

public class SwapPairs {


    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode prevNode = null;
        ListNode curNode = head;
        ListNode nextNode;
        while (curNode != null) {
            if (curNode.next == null) {
                //下个节点为空
                break;
            }
            //交换
            nextNode = curNode.next;
            curNode.next = nextNode.next;
            nextNode.next = curNode;
            if (prevNode != null) {
                prevNode.next = nextNode;
            } else {
                head = nextNode;
            }
            prevNode = curNode;
            curNode = curNode.next;
        }
        return head;
    }

}
