package upgrade_zuo;


public class Code_BiggestSubBSTInTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }


//    public static Node biggestSubBST(Node head) {
//        int[] record = new int[3];//0->size ; 1->min; 2->max
//        return posOrder(head, record);
//    }

    public static class ReturnType {
        public int size;//本树上最大二叉搜索子树的size
        public Node head;//本树上最大二叉搜索子树的head
        public int min;//本树上最大二叉搜索子树的min
        public int max;//本树上最大二叉搜索子树的max

        public ReturnType(int size, Node head, int min, int max) {
            this.size = size;
            this.head = head;
            this.min = min;
            this.max = max;
        }
    }

//    private static Node posOrder(Node head, int[] record) {
//
//
//    }

    public static ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(0, null, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        //左右子树一定会返回ReturnType这样的信息
        Node left = head.left;
        ReturnType leftSubTressInfo = process(left);
        Node right = head.right;
        ReturnType rightSubTressInfo = process(right);
        int includeItSelf = 0;
        if (leftSubTressInfo.head == left && rightSubTressInfo.head == right &&
                head.value > leftSubTressInfo.max && head.value
                < rightSubTressInfo.min) {
            //如果左部最大二叉搜索子树的头部是我的左孩子，如果右部最大二叉搜索子树的头部是我的右孩子
            //当前值大于左部最大二叉搜索子树的最大值
            //当前值小于右部最大二叉搜索子树的最小值
            //则为情况3，自身就是最大二叉搜索子树
            includeItSelf = leftSubTressInfo.size + 1 + rightSubTressInfo.size;
        }
        //如果最大二叉搜索树来自于左树
        int p1 = leftSubTressInfo.size;
        //如果最大二叉搜索树来自于右树
        int p2 = rightSubTressInfo.size;
        //此树的最大值
        int maxSize = Math.max(Math.max(p1, p2), includeItSelf);
        //返回子树可能的最大的头
        Node maxHead = p1 > p2 ? leftSubTressInfo.head : rightSubTressInfo.head;
        if (maxSize == includeItSelf) {
            maxHead = head;
        }

        return new ReturnType(maxSize, maxHead,
                Math.min(Math.min(leftSubTressInfo.min, rightSubTressInfo.min), head.value),
                Math.max(Math.max(leftSubTressInfo.min, rightSubTressInfo.max), head.value));
    }

}
