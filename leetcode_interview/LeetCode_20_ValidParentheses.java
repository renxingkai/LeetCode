package leetcode_interview;

import java.util.Stack;

public class LeetCode_20_ValidParentheses {

    /**
     * 使用栈进行判断
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.equals(""))
            return true;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (stack.isEmpty()) {
                    //如果栈空了，直接返回false
                    return false;
                }
                char cur = stack.pop();
                if (cur == '(' && s.charAt(i) != ')') return false;
                if (cur == '[' && s.charAt(i) != ']') return false;
                if (cur == '{' && s.charAt(i) != '}') return false;
            }
        }
        //最终判断下栈是不是空
        return stack.isEmpty() ? true : false;

    }


}
