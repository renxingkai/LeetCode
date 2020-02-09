public class LeetCode_953 {
    //https://leetcode.com/problems/verifying-an-alien-dictionary/discuss/277043/Simple-Java-solution-0ms.
    public static void main(String[] arg) {

    }

    public boolean isAlienSorted(String[] words, String order) {
        boolean ret = true;
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            ret = isSorted(s1, s2, order);
            if (!ret) {
                return ret;
            }
        }
        return ret;
    }

    private boolean isSorted(String s1, String s2, String order) {
        int minLen = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLen; i++) {
            int idx1 = order.indexOf(s1.substring(i, i + 1));
            int idx2 = order.indexOf(s2.substring(i, i + 1));
            if (idx1 < idx2) {
                return true;
            } else if (idx2 < idx1) {
                return false;
            }
        }
        if (s1.length() > s2.length()) {
            // apple, app
            return false;
        }

        return true;
    }

}
