package leetcode_interview;

public class LeetCode_69_Sqrtx {

    /**
     * 二分法
     * 时间复杂度更低
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        int magicNum = (int) Math.sqrt(Integer.MAX_VALUE);
        int start = 1;
        int end = magicNum;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return mid;
            }
            if (mid * mid > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (end * end <= x) {
            return end;
        } else {
            return start;
        }
    }


    /**
     * 根据等差数列 构建平方数
     *
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x <= 0) {
            return 0;
        }
        int curr = 0;//记录当前的平方数
        int res = 0;
        int add = 1;//记录差值 相邻平方数之间的差值
        while (curr <= x) {
            if (Integer.MAX_VALUE-curr  < add) {
                //判断溢出
                return res;
            }
            curr += add;
            add += 2;
            res++;

        }
        return res - 1;
    }
}
