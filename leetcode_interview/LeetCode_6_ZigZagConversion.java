package leetcode_interview;

public class LeetCode_6_ZigZagConversion {

    /**
     * @param s       字符串
     * @param numRows 行数
     * @return
     */
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        //建立StringBuilder
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        //初始化
        for (int i = 0; i < stringBuilders.length; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int i = 0;
        while (i < len) {
            //从上往下走
            for (int idx = 0; idx < numRows && i < len; idx++) {
                stringBuilders[idx].append(c[i++]);
            }
            //之字形，从下往上走
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
                stringBuilders[idx].append(c[i++]);
            }
        }
        for (int idx = 1; idx < stringBuilders.length; idx++) {
            stringBuilders[0].append(stringBuilders[idx]);
        }
        return stringBuilders[0].toString();
    }

}
