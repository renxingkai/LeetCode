package leetcode;

public class MyAtoi {

    public static void main(String[] args) {

    }

    public int myAtoi(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        int sign = 1;
        int base = 0;
        int i = 0;
        int n = str.length();
        //跳过空格符
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i++) == '+') ? 1 : -1;
        }
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            //越界
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }


}
