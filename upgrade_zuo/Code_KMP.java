package upgrade_zuo;

public class Code_KMP {

    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;//甲
        int i2 = 0;//乙
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            //如果甲字符和乙字符相等，同时++
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                //说明甲、乙 第一个字符都配不上
                //则甲换一个字符继续配
                i1++;
            } else {
                //乙可以跳，则从next数组拿出来该值
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    private static int[] getNextArray(char[] str2) {
        if (str2.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        //i是来到的位置
        int i = 2;
        //cn是跳的位置
        int cn = 0;
        while (i < next.length) {
            //如果当前跳的位置和前一个位置是一样的
            if (str2[i - 1] == str2[cn]) {
                //i位置的长度为跳到位置长度++
                next[i++] = ++cn;
            } else if (cn > 0) {
                //还可以继续往前跳,cn再往前跳
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(getIndexOf("abcds ha","sh"));
    }


}
