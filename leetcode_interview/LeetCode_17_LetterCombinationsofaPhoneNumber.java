package leetcode_interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_17_LetterCombinationsofaPhoneNumber {

    //--------------------------------DFS----------------------------------------------

    /**
     * DFS
     * 需要传递递归函数的变量
     * String current, int index ,map ,result, num
     * 递归终止条件,index=num.length() ,current(存入)-->result
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        HashMap<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        helper("", 0, digits, res, map);
        return res;
    }

    private void helper(String curr, int currIdx, String digits, List<String> res, HashMap<Character, char[]> map) {
        if (currIdx == digits.length()) {
            //终止条件
            //处理完所有的数字,index到了最后一位
            res.add(curr);
        } else {
            char c = digits.charAt(currIdx);
            if (map.containsKey(c)) {
                //map中含有c,则附加到cur后面
                for (char ch : map.get(c)) {
                    helper(curr + ch, currIdx + 1, digits, res, map);
                }
            }
        }
    }
    //------------------------------------------------------------------------------


    //------------------------------BFS------------------------------------------------

    /**
     * 通常需要一个Queue
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        List<String> res = new LinkedList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        HashMap<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        helper("", 0, digits, res, map);
        return res;
    }

}
