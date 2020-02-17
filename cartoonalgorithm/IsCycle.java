package cartoonalgorithm;

/**
 * 判断环长：
 * 环长=每一次速度差*前进次数=前进次数
 *
 * 判断入环节点:
 * 首次相遇之后，把其中一个指针放回头节点位置，另一个指针保持首次相遇点，两个‘
 * 指针都是每次向前走1步，那么，他们最终相遇的点，就是入环节点
 */
public class IsCycle {

    /***
     * 判断链表是否有环
     * 使用快慢指针。
     * fast一次走两个,slow一次走一个
     * 相遇了则说明有环
     * @param head
     * @return
     */
    public static boolean isCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while (slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                //两指针相遇
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(6);
        Node node5 = new Node(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        System.out.println(isCycle(node1));
    }


}
