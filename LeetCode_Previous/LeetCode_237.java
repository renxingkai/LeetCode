public class LeetCode_237 {

    public static void main(String[] arg) {

    }

    /**
     * 题目被喷，确实存在一定问题，删除时候不明确
     * @param node
     */
    public static void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }


}
