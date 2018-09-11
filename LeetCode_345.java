/**
 * Reverse Vowels of a String
 */
public class LeetCode_345 {

    public static void main(String[] arg) {
        System.out.println(reverseVowels("leetcode"));
    }

    /**
     * 直接设置两个指针，一个指针从前开始遍历，一个指针从后开始遍历，
     * 如果遇到元音字母则判断i j对应的元素是否都是元音字母，若是的话，直接交换，否则变化i j 对应的元素
     *
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        String res = null;
        while (i <= j) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U') {
                if (s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o' || s.charAt(j) == 'u' || s.charAt(j) == 'A' || s.charAt(j) == 'E' || s.charAt(j) == 'I' || s.charAt(j) == 'O' || s.charAt(j) == 'U') {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    i++;
                    j--;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }
        res = new String(chars);
        return res;
    }
}
