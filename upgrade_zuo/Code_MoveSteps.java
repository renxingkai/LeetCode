package upgrade_zuo;

public class Code_MoveSteps {

    /**
     * @param N 一共1~N位置
     * @param M 来到的位置
     * @param P 可以走的步数
     * @param K 最终停留在的位置
     * @return 一共多少种走法
     */
    public static int ways(int N, int M, int P, int K) {
        if (N < 2 || M < 1 || M > N || P < 0 || K < 1 || K > N) {
            return 0;
        }
        if (P == 0) {
            //步数走完了，看M是否走到了K
            return M == K ? 1 : 0;
        }
        int res = 0;
        if (M == 1) {
            //M在初始位置，只能往右走
            res = ways(N, M + 1, P - 1, K);
        } else if (M == N) {
            //M在最终位置，只能往左走
            res = ways(N, M - 1, P - 1, K);
        } else {
            //
            res = ways(N, M + 1, P - 1, K) + ways(N, M - 1, P - 1, K);
        }
        return res;
    }

}
