package leetcode_interview;

public class LeetCode_43_Multiply_Strings {

    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) {
            return "0";
        }
        //两整数相乘最大len1+len2位
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                //计算乘积
                int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                //低位
                int posLow=i+j+1;
                //高位
                int posHigh=i+j;
                //先填低位 mul可能为13.。
                mul+=result[posLow];
                result[posLow]=mul%10;
                //高位
                result[posHigh]+=mul/10;
            }
        }
        //删除开始多余的0
        StringBuilder sb=new StringBuilder();
        for (int res:result){
            if (!(res==0&&sb.length()==0)){
                sb.append(res);
            }
        }
        return (sb.length()==0)?"0":sb.toString();
    }

}
