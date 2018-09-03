import java.util.List;

/**
 * 首先统计两条链表的长度，把长的链表比短的链表多出来的一截去掉，然后再用两个指针同时开始走，如果有相同的，说明链表有部分重合，则返回
 */
public class LeetCode_160 {

    public static void main(String[] arg) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //获取A、B链表长度
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        ListNode itA = headA;
        ListNode itB = headB;

        int dis = lengthA - lengthB;

        if (dis >= 0) {
            //如果A比B长，则itA移过多余的部分
            for (int i = 0; i < dis; i++) {
                itA = itA.next;
            }
        } else {
            //如果B比A长，则itB移过多余的部分
            for (int i = 0; i < -dis; i++) {
                itB = itB.next;
            }
        }
        //遍历两条链表，寻找是否有相同的元素
        while (itA != null && itB != null) {
            if (itA == itB) {
                return itA;
            } else {
                itA = itA.next;
                itB = itB.next;
            }
        }

        return null;
    }

    /**
     * 获取链表长度
     *
     * @param head
     * @return
     */
    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int length = 0;
        ListNode it = head;
        while (it != null) {
            it = it.next;
            length++;
        }
        return length;
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