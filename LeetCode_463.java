public class LeetCode_463 {

    public static void main(String[] arg) {

    }

    /**
     * 只需要计算为1的方格数量和重复的边数即可. 为防止重复计算重合边, 每次只往
     * <p>
     * 回查看, 也就是如果一个方格为1, 只查看左边和上边的方格是否为1.
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        int repeat = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) continue;
                count++;
                if (i != 0 && grid[i - 1][j] == 1) {
                    repeat++;
                }
                if (j != 0 && grid[i][j - 1] == 1) {
                    repeat++;
                }
            }
        }
        return count * 4 - repeat * 2;

    }
}
