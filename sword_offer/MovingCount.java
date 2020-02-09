package loadoffer;

public class MovingCount {

    public static void main(String[] args) {

    }

    /**
     * version_3:回溯法
     * 核心思路：
     * 1.从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索，
     * 返回1 + 4 个方向的探索值之和。
     * 2.探索时，判断当前节点是否可达的标准为：
     * 1）当前节点在矩阵内；
     * 2）当前节点未被访问过；
     * 3）当前节点满足limit限制。
     * 3.
     * 运行时间：31ms
     * <p>
     * ————————————————
     * 版权声明：本文为CSDN博主「HelloZEX」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/HelloZEX/article/details/81089228
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return countingSteps(threshold, rows, cols, 0, 0, visited);
    }

    private int countingSteps(int limit, int rows, int cols, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || bitSum(r)+bitSum(c) > limit) {
            return 0;
        }
        visited[r][c] = true;
        return countingSteps(limit, rows, cols, r - 1, c, visited) +
                countingSteps(limit, rows, cols, r, c - 1, visited) +
                countingSteps(limit, rows, cols, r + 1, c, visited) +
                countingSteps(limit, rows, cols, r, c + 1, visited) + 1;


    }

    private int bitSum(int c) {
        int count = 0;
        while (c != 0) {
            count += c % 10;
            c /= 10;
        }
        return count;
    }

}
