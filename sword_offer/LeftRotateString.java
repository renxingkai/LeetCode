package loadoffer;

public class LeftRotateString {

    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcXYZdef", 3));
    }

    /**
     * 通过16.67%
     *
     * @param str
     * @param n
     * @return
     */
    public static String LeftRotateString(String str, int n) {
        if (n == 1) {
            return str;
        }
        String remove = "";
        for (int i = 0; i < n; i++) {
            remove += str.charAt(i);
        }
        String pre = "";
        for (int i = n; i < str.length(); i++) {
            pre += str.charAt(i);
        }

        return pre + remove;

    }


    public static String LeftRotateString2(String str, int n) {
        if(n>str.length())
            return "";
        return str.substring(n, str.length()) + str.substring(0, n);
    }

}
