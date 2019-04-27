public class LeetCode_1021 {

    public static void main(String[] arg) {

    }

    //移除最外层的多余括号

    /**
     * 当出现最外层括号的时候即左括号和右括号的个数相等，
     * 所以，我们用一个字符tmp串记录下当前的子串，用cnt表示左右括号个数的和
     * （ps： 碰到左括号 cnt 加一  碰到右括号 cnt 减一） 当cnt = 0 的时候  左括号和右括号相等。
     * 去除掉 tmp的头尾 即是我们当前所求的结果 。清除tmp 。以此重复到字符串结束。ans  get ！！ ！
     * ---------------------
     *
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {
        String res = "";
        int count = 0;
        String tmp = "";
        for (int i = 0; i < S.length(); i++) {
            tmp += S.charAt(i) + "";
            if (S.charAt(i) == '(') {
                //出现左括号，count+1
                count++;
            } else {
                //出现右括号，count-1
                count--;
            }
            if (count == 0) {
                //count==0 说明左右括号相等了
                int len = tmp.length();
                //去掉最外面的括号
                res += tmp.subSequence(1, len - 1);
                tmp = "";
            }
        }
        return res;


    }
}
