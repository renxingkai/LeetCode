package leetcode_interview;

public class LeetCode_65_ValidNumber {

    /**
     * 判断是不是有效数字
     * 一位位检测
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //检测前缀0
        int i = 0;
        int n = s.length();
        //跨过空格
        while (i < n && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        //检测+/-号
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        //检测数字位
        boolean isDigital = false;
        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isDigital = true;
        }
        //检测小数点
        if (i < n && s.charAt(i) == '.') {
            i++;
            //检测小数部分
            while (i < n && Character.isDigit(s.charAt(i))) {
                isDigital = true;
                i++;
            }
        }
        if (i < n && s.charAt(i) == 'e' && isDigital) {
            //检测指数部分
            i++;
            isDigital = false;
            //检测正负号、
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isDigital = true;
            }
        }
        //处理末尾空格
        while (i<n&& Character.isWhitespace(s.charAt(i))){
            i++;
        }
        return isDigital&&i==s.length();
    }

}
