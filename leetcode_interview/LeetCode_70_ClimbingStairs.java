package leetcode_interview;

public class LeetCode_70_ClimbingStairs {

    /**
     * DP
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int[] res = new int[n];
        res[0]=1;
        res[1]=2;
        //转移方程
        //[i]=[i-1]+[i-2]
        for (int i=2;i<n;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res[n-1];
    }

    /**
     * DP
     *优化空间
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        //第二个台阶开始
        int prev=1;
        int curr=2;
        //转移方程
        //curr=curr+prev
        for (int i=3;i<=n;i++){
            curr=curr+prev;
            prev=curr-prev;
        }
        return curr;
    }
}
