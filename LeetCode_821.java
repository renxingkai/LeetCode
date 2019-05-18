public class LeetCode_821 {


    public static void main(String[] arg) {

    }

    /**
     * 需要进行前后双向遍历，选出最小的元素
     * @param S
     * @param C
     * @return
     */
    public int[] shortestToChar(String S, char C) {

        int[] ans = new int[S.length()];

        int index = (int) (-1e9);
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                index = i;
            }
            ans[i] = i - index;
        }
        index = (int) (1e9);
        for (int i = S.length()-1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                index = i;
            }
            ans[i] = Math.min(ans[i], index - i);
        }
        return ans;
    }


}
