package cn.rxk;

/**
 * //提取出字符串中的字母字符和数字字符
 * for (int i = 0; i < s.length(); i++) {
 * if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) <= '9' && s.charAt(i) >= '0')) {
 * cutAfter += s.charAt(i);
 * } else {
 * continue;
 * }
 * }
 * 会TLE
 */

/**
 * 最后通过全部转为小写，依次判断首尾元素是否相同
 */
public class LeetCode_125 {

    public static void main(String[] arg) {
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int j = s.length() - 1;
        int i = 0;
        /**
         * 判断首尾元素是否相同
         */
        while (i < j) {
            if ((s.charAt(i) > 'z' || s.charAt(i) < 'a') && (s.charAt(i) > '9' || s.charAt(i) < '0')) {
                i++;
            } else if ((s.charAt(j) > 'z' || s.charAt(j) < 'a') && (s.charAt(j) > '9' || s.charAt(j) < '0')) {
                j--;
            } else if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

}
