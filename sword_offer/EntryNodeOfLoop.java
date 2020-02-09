package loadoffer;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/*
 *     首先判断链表中是否有环 思路是用两个指针，同时从链表的节点出发
 *     一个走的慢，一个走的快
 *     如果两个指针不能相遇则无环，否则有环
 *
 *     如何找到环的入口？
 *     还是先定义两个指针，p1,p2
 *     n代表链表中环的节点个数
 *     p1先向前移动n步
 *     然后两个指针以相同的速率向前移动
 *     两个指针相遇的地方就是环的入口地址（总结规律出来的）
 *
 *     接下来就是如何求环中节点的个数
 *     两个指针相遇的地方一定是在环的内部
 *     所以可以从这个节点出发，边走边计数
 *     当再次回到这个节点的时候  就知道环中节点的个数了
 * */
public class EntryNodeOfLoop {

    public static void main(String[] args) {

    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        //返回相遇的节点
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null) {
            return null;
        }
        int countOfLoop = 1;
        ListNode node1 = meetingNode.next;
        //求出圈的长度
        while (node1 != meetingNode) {
            countOfLoop++;
            node1 = node1.next;
        }
        //p1向前移动圈长的长度
        node1 = pHead;
        for (int i = 0; i < countOfLoop; i++) {
            node1 = node1.next;
        }
        //两个节点同时向前移动  相遇的地方就是圈的开始
        ListNode node2 = pHead;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    private ListNode meetingNode(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode slowNode = pHead;
        ListNode fastNode = slowNode.next;
        while (fastNode != null && slowNode != null) {
            if (fastNode == slowNode) {
                return fastNode;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (fastNode != null) {
                fastNode = fastNode.next;
            }
        }
        return null;
    }

}
