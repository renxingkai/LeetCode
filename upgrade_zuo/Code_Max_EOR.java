package upgrade_zuo;

import leetcode.MyAtoi;

/*
条件:
E1^E2=E3
结论:
E1=E3^E2
E2=E3^E1

0--i=[0--start-1]^[start--i]
 */
public class Code_Max_EOR {

    /**
     * dp
     *
     * @param arr
     * @return
     */
    public static int getMaxE2(int[] arr) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];//记录结果
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];//eor 为0---i的异或结果
            max = Math.max(max, eor);
            for (int start = 1; start <= i; start++) {
                //保留前面的值
                int curEor = eor ^ dp[start - 1];//curEor start--i的异或结果
                max = Math.max(max, curEor);
            }
            dp[i] = eor;
        }
        return max;
    }

    public static class Node {
        public Node[] nexts = new Node[2];//前缀树，只有两个路 0和1
    }

    public static class NumTrie {
        public Node head = new Node();

        public void add(int num) {
            Node cur = head;
            for (int move = 31; move >= 0; move--) {
                int path = ((num >> move) & 1);//num右移31位,符号位来到了最左的位置,提取出每个进制位的数字
                //当前节点走向path的路是空的话，建立出来，不为空 添加上去
                cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
                cur = cur.nexts[path];
            }
        }

        /**
         * @param num 从0--i的异或结果
         * @return
         */
        public int maxXor(int num) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                //从高位往地位依次提取每位
                int path = (num >> move) & 1;
                //选择最优路
                //对于符号位来说，走过前缀树的路应和选择的值是一样的
                //不是符号位，选择路径应和当前不一样
                //期待要选的路
                int best = move == 31 ? path : (path ^ 1);
                //查看best路径是否为空,为空只能选择另一条路
                //实际要选的路
                best = cur.nexts[best] != null ? best : (best ^ 1);
                //依次设置32-->1位 ，设置每一位
                res |= (path ^ best) << move;
                cur = cur.nexts[best];
            }
            return res;
        }
    }

    public static int maxXorSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int eor = 0;//0--i的异或
        NumTrie numTrie = new NumTrie();
        numTrie.add(0);
        for (int i = 0; i < arr.length; i++) {
            //0--i的异或
            eor ^= arr[i];
            max = Math.max(max, numTrie.maxXor(eor));
            numTrie.add(eor);
        }
        return max;
    }


}
