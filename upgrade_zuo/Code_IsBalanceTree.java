package upgrade_zuo;

public class Code_IsBalanceTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }

//    public static boolean isB(Node head) {
//
//    }

    public static class ReturnData {
        int h;
        boolean isB;

        public ReturnData(int h, boolean isB) {
            this.h = h;
            this.isB = isB;
        }
    }

    public static ReturnData process(Node head) {
        if (head == null) {
            return new ReturnData(0, true);
        }
        ReturnData leftData = process(head.left);
        if (!leftData.isB) {
            return new ReturnData(0, false);
        }
        ReturnData rightData = process(head.right);
        if (!rightData.isB) {
            return new ReturnData(0, false);
        }
        if (Math.abs(leftData.h-rightData.h)>1){
            return new ReturnData(0,false);
        }
        return new ReturnData(Math.max(leftData.h,rightData.h)+1,true);
    }

}
