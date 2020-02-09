/**
 * 使用取余方法，类似于十进制进位
 */
public class LeetCode_168 {

    public static void main(String[] arg) {
        System.out.println(convertToTitle(701));
    }

    public static String convertToTitle(int n) {
        if (n==0){
            return null;
        }
        String result="";
        while (n!=0){
            char s = (char) ((n-1)%26+'A');
            result=s+result;
            n=(n-1)/26;
        }
        return result;
    }

}
