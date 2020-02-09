package upgrade_zuo;

import java.util.LinkedList;
import java.util.Queue;

public class Code_IsCompeleteBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    /**
     * 1)一个节点有右无左
     * 2)不违反1) 如果当前左右不全，则接下来的节点必须全部为叶节点
     *
     * @param head
     * @return
     */
    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;//2)过程是否开启
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            //取出头节点
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (     //检测2过程
                    (leaf && (l != null || r != null)) ||
                            //有右无左
                            (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }


}
