public class LeetCode_883 {
    //参考
    //https://blog.csdn.net/qq_30216191/article/details/81811146
    public static void main(String[] arg) {

    }

    public int projectionArea(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int rowMax = 0;
        int colMax = 0;
        for (int i = 0; i < m; i++) {
            rowMax = 0;
            colMax = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    //俯视投影如果有值，直接加一就好，因为必为一个影子
                    count++;
                }
                //行中最大值
                rowMax = Math.max(grid[i][j], rowMax);
                //列中最大值
                colMax = Math.max(grid[j][i], colMax);
            }
            count += (rowMax + colMax);
        }
        return count;


    }


}
