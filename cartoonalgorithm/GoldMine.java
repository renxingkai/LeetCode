package cartoonalgorithm;

public class GoldMine {

    /**
     * 获取金矿最优的收益
     *
     * @param w 工人数量
     * @param p 金矿开采需要的工人数量
     * @param g 金矿储量
     * @return
     */
    public static int getBestGoldMiningV2(int w, int[] p, int[] g) {
        //创建dp表格
        int[][] resultTable = new int[g.length + 1][w + 1];
        for (int i = 1; i <= g.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i - 1]) {
                    //人数少
                    resultTable[i][j] = resultTable[i - 1][j];
                } else {
                    resultTable[i][j] = Math.max(resultTable[i - 1][j], resultTable[i - 1][j - p[i - 1]] + g[i - 1]);
                }
            }
        }
        return resultTable[g.length][w];
    }


    /**
     * 获取金矿最优的收益
     * space O（n）
     * @param w 工人数量
     * @param p 金矿开采需要的工人数量
     * @param g 金矿储量
     * @return
     */
    public static int getBestGoldMiningV3(int w, int[] p, int[] g) {
        //创建当前结果
        int[] results = new int[w + 1];
        //填充一维数组
        for (int i = 1; i <= g.length; i++) {
            for (int j = w; j >= 1; j--) {
                if (j > p[i - 1]) {
                    results[j] = Math.max(results[j], results[j - p[i - 1] + g[i - 1]]);
                }
            }
        }

        return results[w];
    }

}
