package leetcode_interview;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_3_LengthOfLongestSubstring {

    /**
     * 用一个hashmap保存字符串中每个字符，<ch,index> index为字符出现的位置
     * 无重复最长子串即为 max(一个存在重复字符 之间的距离)
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int pre = -1;//记录一个字符之前出现的位置
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                //取出当前该字符s.charAt(i) 首先出现的最大位置
                pre = Math.max(pre, hashMap.get(s.charAt(i)));
            }
            //无重复最长子串即为 如果出现重复字符，则两个重复字符之间的最大距离
            max = Math.max(max, i - pre);
            //更新每个<char,index>
            hashMap.put(s.charAt(i), i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

}
