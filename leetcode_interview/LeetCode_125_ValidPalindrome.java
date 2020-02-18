package leetcode_interview;

public class LeetCode_125_ValidPalindrome {

    /**
     * 双指针判断回文
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        //左指针
        int start = 0;
        //右指针
        int right = s.length() - 1;
        while (start < right) {
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                //如果不是字符
                right--;
            } else if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else {
                if (s.charAt(start) != s.charAt(right)) {
                    //有一个不相等就返回
                    return false;
                }
                right--;
                start++;
            }
        }
        return true;
    }

}
