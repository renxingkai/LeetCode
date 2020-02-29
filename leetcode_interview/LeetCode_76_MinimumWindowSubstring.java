package leetcode_interview;

public class LeetCode_76_MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        //与t匹配上的字符个数
        int matchCount = 0;
        String res = "";
        //记录t字符出现的个数
        int[] tArr = new int[256];
        for (char c : t.toCharArray()) {
            tArr[c]++;
        }
        //记录s字符出现的个数
        int[] sArr = new int[256];
        //左右指针
        int left = findNextStrIdx(0, s, tArr);
        if (left == s.length()) {
            return "";//没有匹配上
        }
        int right = left;
        //找到第一个char在t中，开始的位置
        while (right < s.length()) {
            int rightChar = s.charAt(right);
            if (sArr[rightChar] < tArr[rightChar]) {
                //匹配到一个字符要总匹配数要加一
                matchCount++;
            }
            sArr[rightChar]++;
            while (left < s.length() && matchCount == t.length()) {
                //匹配上了  res.length() >= right - left + 1以前找到的更长
                if (res.isEmpty() || res.length() >= right - left + 1) {
                    //更新res
                    res = s.substring(left, right + 1);
                }
                //更新了之后，要开始移动左指针
                //res不为空
                int leftChar = s.charAt(left);
                if (sArr[leftChar] <= tArr[leftChar]) {
                    //左指针开始移动，所以要将匹配的--
                    matchCount--;
                }
                ////左指针开始移动，所以要将相应的数组的元素--
                sArr[leftChar]--;
                left = findNextStrIdx(left + 1, s, tArr);
            }
            //没匹配上继续移动右指针
            right = findNextStrIdx(right + 1, s, tArr);
        }
        return res;

    }

    private int findNextStrIdx(int i, String s, int[] tArr) {
        while (i < s.length()) {
            char c = s.charAt(i);
            if (tArr[c] != 0) {
                //字符在t中包含，则返回s中的索引
                return i;
            }
            i++;
        }
        return i;
    }

}
