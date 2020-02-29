package leetcode_interview;

import java.util.Arrays;

public class LeetCode_87_ScrambleString {

    /**
     * 分治法
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        //s1和s2长度相等，则返回true
        if (s1.length() == 1 && s1.equals(s2)) {
            return true;
        }
        char[] s1char = s1.toCharArray();
        char[] s2char = s2.toCharArray();
        Arrays.sort(s1char);
        Arrays.sort(s2char);
        String str1 = new String(s1char);
        String str2 = new String(s2char);
        //如果两个字符串Scramble，则长度应该相同
        if (!str1.equals(str2)) {
            return false;
        }
        for (int length = 1; length < s1.length(); length++) {
            //分割左右字符串
            String s1Left = s1.substring(0, length);
            String s1Right = s1.substring(length, s1.length());
            //左跟左match，同时右跟右match
            //s1的左和s2的右match，并且s1的右和s2的左match
            if (isScramble(s1Left, s2.substring(0, length)) && isScramble(s1Right, s2.substring(length, s2.length())) ||
                    (isScramble(s1Left, s2.substring(s2.length() - length, s2.length())) &&
                            isScramble(s1Right, s2.substring(0, s2.length() - length)))) {
                return true;
            }
        }
        return false;

    }


    public static void main(String[] args) {

    }


}
