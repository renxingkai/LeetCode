package upgrade_zuo;

public class Code_Match {

    /**
     * str[i...一直到最后] 这个字符串，能不能被exp[j...]的这个字符串匹配出来
     *
     * @param str
     * @param exp
     * @param i
     * @param j
     * @return
     */
    public static boolean process(char[] str, char[] exp, int i, int j) {
        if (j == exp.length) {
            //当exp完了，str也必须完
            return i == str.length;
        }
        if (j + 1 == exp.length || exp[j + 1] != '*') {
            //j前面还有字符，考察j+1的情况
            //i不能等于str的长度，因为j还没完
            return i != str.length &&
                    //当前i 和j位置相等  或者j位置为.
                    (exp[j] == str[i] || exp[j] == '.') &&
                    //并且i+1位置和j+1位置能配上
                    process(str, exp, j + 1, i + 1);
        }
        //i没走完，并且i和j都能配上
        //exp的j+1位置 不仅有字符而且是*
        while (i != str.length && (exp[j] == str[i] || exp[j] == '.')) {
            if (process(str, exp, i, j + 2)) {
                //假设0个str[i]
                return true;
            }
            i++;
        }
        return process(str, exp, i, j + 2);
    }

//    public static boolean isMatchDp(char[] str, char[] exp) {
//
//    }


}
