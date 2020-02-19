package leetcode_interview;

//https://www.cnblogs.com/mini-coconut/p/9074315.html
public class LeetCode_5_LongestPalindromicSubstring {


    /**
     * boolean [n][n] 代表从i-->j是否是一个回文串
     * [i][i] 一定是true
     * [i][i+1] 判断相等是true,不相等是false
     * [i][j] : fasle if [i]==[j]
     * else: [i+1][j-1] 需要去看i+1到j-1
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        //用start和length记录，从哪一点开始
        int maxLen = Integer.MIN_VALUE;
        String res = "";
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        //[i][i]一定为true
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i + len <= s.length(); i++) {
                if (len == 1) {
                    //长度为1 全部为回文
                    isPalindrome[i][i + len - 1] = true;
                } else if (len == 2) {
                    //查看首尾是否相等 i i+1
                    isPalindrome[i][i + len - 1] = (s.charAt(i) == s.charAt(i + len - 1)) ? true : false;
                } else {
                    //查看首尾相等，并且[i+1][j-1] 需要去看i+1到j-1
                    isPalindrome[i][i + len - 1] = (s.charAt(i) == s.charAt(i + len - 1)) && isPalindrome[i + 1][i + len - 2];
                }
                if (isPalindrome[i][i + len - 1] == true) {
                    if (len > maxLen) {
                        //更新最大值
                        maxLen = len;
                        res = s.substring(i, i + len);
                    }
                }
            }
        }
        return res;
    }
}
