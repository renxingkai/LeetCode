package leetcode_interview;

public class LeetCode_9_PalindromeNumber {

    /**
     * div为x长度 10000,eg:x=13231 div=10000
     * num=(num-div)/10
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
//        int div=String.valueOf(x).length();
        int div = 1;
        int num = x;
        while (num / div >= 10) {
            div *= 10;
        }
        while (num != 0) {
            //取出左边和右边的数
            int leftNum = num / div;
            int rightNum = num % 10;
            if (leftNum != rightNum) {
                return false;
            }
            //减去最高位和除以10 会消去最高位和最低位
            num = (num - leftNum * div) / 10;
            //一次删除两个数，div应该除以100
            div /= 100;
        }
        return true;
    }

}
