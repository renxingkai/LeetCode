package leetcode_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode_49_GroupAnagrams {

    /**
     * 使用HashMap进行操作
     * 对字母进行排序后，当做key
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            String key = String.valueOf(curr);
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new ArrayList<String>());
            }
            hashMap.get(key).add(strs[i]);
        }
        return new ArrayList<List<String>>(hashMap.values());
    }

}
