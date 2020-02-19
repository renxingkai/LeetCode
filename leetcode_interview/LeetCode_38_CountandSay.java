package leetcode_interview;

public class LeetCode_38_CountandSay {

    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        //初试值设为1
        String str = "1";
        for (int i = 1; i < n; i++) {
            int count = 0;//记录出现了多少个字符
            char prev = '.';//记录当前看到的字符
            StringBuilder sb = new StringBuilder();
            for (int idx = 0; idx < str.length(); idx++) {
                if (str.charAt(idx) == prev || prev == '.') {
                    count++;//记录count+1
                } else {
                    //不相等，需要统计要返回的字符串
                    sb.append(count + Character.toString(prev));
                    count = 1;//count重置为1
                }
                //每次prev都是当前的字符
                prev = str.charAt(idx);
            }
            //添加最后的
            sb.append(count + Character.toString(prev));
            str = sb.toString();
        }
        return str;
    }


}
