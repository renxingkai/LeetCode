package leetcode;

import java.util.HashMap;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {

    }

    /**
     * 使用HashMap记录字符上次出现的位置，用pre记录最近重复字符出现的位置，
     * 则i(当前位置)-pre就是当前字符最长无重复字符的长度，
     * 取最大的就是字符串的最长无重复字符的长度
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        //记录最近出现重复字符的位置
        int pre = -1;
        for (int i = 0, strLen = s.length(); i < strLen; i++) {
            Character ch=s.charAt(i);
            Integer index=map.get(ch);
            if (index!=null){
                pre=Math.max(pre,index);
            }
            max=Math.max(max,i-pre);
            map.put(ch,i);
        }
        return max;
    }


}
