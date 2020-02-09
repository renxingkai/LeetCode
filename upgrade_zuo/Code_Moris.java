package upgrade_zuo;

public class Code_Moris {
    public static class Node {
        Node left;
        Node right;
        int value;
    }

    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                //左孩子不为空
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            //左孩子不为空
            System.out.println(cur.value+" ");
            cur = cur.right;
        }
    }


}
