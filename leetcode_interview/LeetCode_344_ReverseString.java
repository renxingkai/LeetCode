package leetcode_interview;

public class LeetCode_344_ReverseString {


    /**
     * 双指针，直接交换left和right
     *
     * @param s
     */
    public void reverseString(char[] s) {
        if (s == null || s.length == 0 || s.length == 1) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}
