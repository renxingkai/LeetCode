import java.util.HashMap;
import java.util.Map;

public class LeetCode_409 {

    public static void main(String[] arg) {

    }

    /**
     * 这道题比较简单，因为只需要输出最长回文串的长度就行
     * 回文串就是从中心对称的，所以任何出现过偶数次的字符都可以算进长度之中，但要注意，回文串中也可以添加一个奇数个的字符，且只能放在中间
     * <p>
     * 我最初的想法是，构建一个 Map ，key：字符，value：出现的次数
     * 然后把所有偶数次的 value 相加，再把奇数次中的最大数相加，可是却入了坑，没能AC
     * <p>
     * 后来发现，可以从奇数次中的字符里取出偶数个也可以加入回文串
     *
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        if (s == null) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        int result = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                result += entry.getValue();
            } else {
                result += entry.getValue() - 1;
            }
        }
        if (result < s.length()) {
            result++;
        }
        return result;
    }


}
