package leetcode_interview;

public class LeetCode_44_WildcardMatching {

    /**
     * DP
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        //s p中0-i 0-j的字符是否匹配
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int pi = 1; pi <= p.length(); pi++) {
            if (p.charAt(pi - 1) == '*') {
//                [0][pi-1]位置由[0][pi]决定
                match[0][pi] = match[0][pi - 1];
            }
        }
        for (int si = 1; si <= s.length(); si++) {
            for (int pi = 1; pi <= p.length(); pi++) {
                //pi-1位置可以匹配
                if (s.charAt(si - 1) == p.charAt(pi - 1) || p.charAt(pi - 1) == '?') {
                    match[si][pi] = match[si - 1][pi - 1];
                } else if (p.charAt(pi - 1) == '*') {
                    //左边和上边 或的结果
                    match[si][pi] = match[si - 1][pi] || match[si][pi - 1];
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
