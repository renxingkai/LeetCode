package leetcode_interview;

public class LeetCode_72_EditDistance {

    /**
     * DP
     *
     * @param s
     * @param t
     * @return
     */
    public int minDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        //状态
        int[][] dis = new int[m + 1][n + 1];
        //初始化，第一行和第一列
        for (int i = 0; i <= m; i++) {
            dis[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dis[0][j] = j;
        }
        //转移方程
        //if [i]==[j]  dis[i][j]=min(dis[i-1][j-1],dis[i-1][j]+1,dis[i][j-1]+1)
        //else dis[i][j]=min(dis[i-1][j-1]+1,dis[i-1][j]+1,dis[i][j-1]+1)
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dis[i][j]=Integer.MAX_VALUE;
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dis[i][j]=Math.min(dis[i-1][j],dis[i][j-1])+1;
                    dis[i][j]=Math.min(dis[i-1][j-1],dis[i][j]);
                }else {
                    dis[i][j]=Math.min(dis[i-1][j],dis[i][j-1])+1;
                    dis[i][j]=Math.min(dis[i-1][j-1]+1,dis[i][j]);
                }
            }
        }
        return dis[m][n];
    }

}
