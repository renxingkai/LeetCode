//https://cloud.tencent.com/developer/article/1373995
public class LeetCode_917 {

    public static void main(String[] arg) {
//        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    public String reverseOnlyLetters(String S) {
        char[] result = S.toCharArray();
        int n = S.length();
        int start = 0;
        int end = S.length() - 1;
        while (start < end) {
            while (start < end && !isLetter(result[start])) {
                start++;
            }
            while (start < end && !isLetter(result[end])) {
                end--;
            }
            if (start<end){
                char temp=result[start];
                result[start]=result[end];
                result[end]=temp;
                start++;
                end--;
            }
        }
        return new String(result);
    }

    public boolean isLetter(char c) {
        return ((c >= 'a') && (c <= 'z') || (c >= 'A') && (c <= 'Z'));
    }
}
