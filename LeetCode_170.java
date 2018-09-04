/**
 * 直接利用累加思想进行求和
 */
public class LeetCode_170 {

    public int titleToNumber(String s) {
        int sum = 0;
        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            tmp = s.charAt(i) - 'A' + 1;
            sum = 26 * sum + tmp;
        }
        return sum;
    }

}
