package leetcode_interview;

public class LeetCode_7_ReverseInteger {

    /**
     * 1.可能数字大于2^31-1 overflow
     * 2.负数处理和正数处理一样  -123%10=-3
     * <p>
     * 123
     * newrev=rev*10+x%10;
     * 0+3
     * 30+2
     * 320+1
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int newrev = rev * 10 + x % 10;
            if ((newrev - x % 10) / 10 != rev) {
                //判断是否越界的情况
                return 0;
            }
            rev = newrev;
            x /= 10;
        }
        return rev;
    }
}
