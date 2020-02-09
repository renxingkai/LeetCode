/*
1.给出一个长度26的数组widths，保存着26个字母打印出来所需要的的屏幕宽度，而每行屏幕宽度都只有100，超过这个宽度的话，字母只能打印到下一行去，给出一段字符串，求出打印后最后一个字母所在的行数，列数。

        思路：

            1.打印字符串，记录行数lines，列数pos，如果pos超过100了，打印到下一行去

            2.时间复杂度O（n）
        ---------------------
        作者：yuweiming70
        来源：CSDN
        原文：https://blog.csdn.net/yuweiming70/article/details/79684506
        版权声明：本文为博主原创文章，转载请附上博文链接！
*/

public class LeetCode_806 {

    public static void main(String[] arg) {

    }

    public int[] numberOfLines(int[] widths, String S) {
        int sum = 0;
        int row = 1;
        for (int i = 0; i < S.length(); i++) {
            int ch = S.charAt(i);
            if (sum + widths[ch - 97] < 101) {
                //加上之后不够100
                sum += widths[ch - 97];
            } else {
                //超出100长度
                sum = 0;
                row++;
                sum = sum + widths[ch - 97];
            }
        }
        return new int[]{row, sum};
    }


}
