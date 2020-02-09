package upgrade_zuo;

public class Code_SingleStack_MaxTree {
    public static class Node {
        Node left;
        Node right;
        int value;
    }

    public static void printInOrder(Node head) {
        if (head == null) {
            return;
        }
        printInOrder(head.left);
        System.out.println(head.value + " ");
        printInOrder(head.right);
    }


}
