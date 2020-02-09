package upgrade_zuo;

public class Code_MaxDistanceInTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

//    public static int maxDistance(Node head) {
//        int[] record = new int[1];
////        return posOrder(head, record);
//    }

    public static class ReturnType {
        public int maxDistance;//一棵树节点之间最大距离
        public int h;//树的高度

        public ReturnType(int maxDistance, int h) {
            this.maxDistance = maxDistance;
            this.h = h;
        }
    }

    public static ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(0, 0);
        }
        ReturnType leftReturnType = process(head.left);
        ReturnType rightReturnType = process(head.right);
        //包含头节点，跨过了左右两子树
        int includeHeadDistance = leftReturnType.h + 1 + rightReturnType.h;
        int p1 = leftReturnType.maxDistance;
        int p2 = rightReturnType.maxDistance;
        //节点之间最大长度
        int resultDistance = Math.max(Math.max(p1, p2), includeHeadDistance);
        //树的高度
        int hitself = Math.max(leftReturnType.h, rightReturnType.h) + 1;
        return new ReturnType(resultDistance, hitself);
    }

    public static int getMaxD(Node head) {
        return process(head).maxDistance;
    }


}
