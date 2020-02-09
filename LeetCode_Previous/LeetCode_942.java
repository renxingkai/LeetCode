public class LeetCode_942 {


    public static void main(String[] arg) {

    }

    //https://blog.csdn.net/iwts_24/article/details/84436773
    public int[] diStringMatch(String S) {
        int max = S.length();
        int len = S.length();
        int min = 0;
        int[] ans = new int[max + 1];
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            if (c == 'D') {
                ans[i] = max--;
            } else {
                ans[i] = min++;
            }
        }
        ans[len] = min;
        return ans;


    }


}
