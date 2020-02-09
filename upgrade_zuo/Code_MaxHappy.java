package upgrade_zuo;

import java.util.ArrayList;
import java.util.List;

public class Code_MaxHappy {

    public static class Node {
        public int huo;//当前节点活跃度
        public List<Node> nexts;//当前节点连接下一层节点

        public Node(int huo) {
            this.huo = huo;
            nexts = new ArrayList<>();
        }
    }

    public static class ReturnType {
        public int lai_huo;
        public int bu_lai_huo;

        public ReturnType(int lai_huo, int bu_lai_huo) {
            this.lai_huo = lai_huo;
            this.bu_lai_huo = bu_lai_huo;
        }
    }

    public static ReturnType process(Node head) {
        int lai_huo = head.huo;
        int bu_lai_huo = 0;
        for (int i = 0; i < head.nexts.size(); i++) {
            Node next = head.nexts.get(i);
            ReturnType nextData = process(next);
            //因为自己来了，后代都不能来
            lai_huo += nextData.bu_lai_huo;
            bu_lai_huo += Math.max(nextData.lai_huo, nextData.bu_lai_huo);

        }
        return new ReturnType(lai_huo, bu_lai_huo);
    }

    public static int getMaxHuo(Node head) {
        ReturnType data = process(head);
        return Math.max(data.bu_lai_huo, data.lai_huo);
    }

//    public static int maxHappy(int[][] matrix) {
//
//    }
//
//    public static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
//
//    }


}
