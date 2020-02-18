package leetcode_interview;

public class LeetCode_345_ReverseVowelsofaString {
    /**
     * 翻转元音字符
     * a e i o u
     *
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        if (s == null || s.length() == 1 || s.length() == 0) {
            return s;
        }
        int left = 0;
        int right = s.length() - 1;
        String vowels = "aeiouAEIOU";
        char[] ss = s.toCharArray();
        while (left < right) {
            if (vowels.contains(String.valueOf(ss[left])) && vowels.contains(String.valueOf(ss[right]))) {
                char temp = ss[left];
                ss[left] = ss[right];
                ss[right] = temp;
                left++;
                right--;
            } else if (!vowels.contains(String.valueOf(ss[left])) && vowels.contains(String.valueOf(ss[right]))) {
                left++;
            } else if (vowels.contains(String.valueOf(ss[left])) && !vowels.contains(String.valueOf(ss[right]))) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return String.valueOf(ss);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

}
