package leetcode_interview;

public class LeetCode_10_RegularExpressionMatching {


    // 输入字符串判断是否合法
    public static boolean isValid(char[] s, char[] e) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '*' || s[i] == '.') {
                return false;
            }
        }
        for (int i = 0; i < e.length; i++) {
            if (e[i] == '*' && (i == 0 || e[i - 1] == '*')) {
                return false;
            }
        }
        return true;
    }

    // --------------------------------------------------------------
    // 暴力递归
    public static boolean isMatch(String str, String exp) {
        if (str == null || exp == null) {
            return false;
        }
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        return isValid(s, e) ? process(s, e, 0, 0) : false;
    }

    /**
     * 函数含义：str[i...一直到最后]这个字符串，能不能被 exp[j..一直到最后]的字符串，
     * 匹配出来
     *
     * @param str：
     * @param exp
     * @param i
     * @param j
     * @return
     */
    public static boolean process(char[] str, char[] exp, int i, int j) {
        // baseCase,当exp 中 j 来到最后位置
        if (j == exp.length) {
            return i == str.length;
        }
        // j 上面还有字符，考察 j + 1 的情况
        if (j + 1 == exp.length || exp[j + 1] != '*') {
            // 如果 i == str.length 表示 i 已经到最后了，返回 false；
            // && 后面如果成立可能返回 true，但是如果不成立则一定返回 false；最后表示
            //i 的 i + 1 位置和 j + 1 匹配才能最终返回 true。
            return i != str.length && (exp[j] == str[i] || exp[j] == '.')
                    && process(str, exp, i + 1, j + 1);
        }
        // 该 while 前提为：exp 的 j + 1 位置，不仅有字符并且字符是 *
        while (i != str.length && (exp[j] == str[i] || exp[j] == '.')) {
            // 如果 i 和 j 位置上可以匹配上（相等或者为 . 都认为是匹配上），
            // 默认还是认为 * 为 0 个 j 值，先从 j + 2 开始看看能不能与 i 位置匹配上；
            if (process(str, exp, i, j + 2)) {
                return true;
            }
            // 如果上面没有返回 true，则 i++，
            // 然后让 j + 2 位置和当前 i 位置开始匹配，
            // 本质上就是认为原来 i 位置上元素和 j 位置上数相等了，即 * 表示有
            //1 个 j 值。依次类推一直尝试。
            i++;
        }
        // 跳过 while 到最后一行情况： str: a,a,a,b；exp：c,*,....；
        // 就是 str 中第一个为 i 位置上 a 和 exp 中第一个 j 位置上 c
        //不匹配，并且 j  位置上不为 .，
        // 所以就从 j + 2 位置开始来看能不能匹配上 i 位置上元素，
        // 相当于默认 c,* 中表示 0 的 c。
        return process(str, exp, i, j + 2);
    }

    public static void main(String[] args) {

    }
}
