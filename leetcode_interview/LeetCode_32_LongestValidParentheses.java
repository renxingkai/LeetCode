package leetcode_interview;

import java.util.Stack;

public class LeetCode_32_LongestValidParentheses {

    /**
     * 使用stack
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int max = 0;
        int leftmost = -1;//记录左边最大有效字符串
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                //栈中弹入(
                stack.push(i);
            } else {
                //遇到反括号
                //栈中有元素，弹出，然后记录i和弹出之后下一个索引位置的差值
                if (stack.isEmpty()) {
                    //为空，leftmost赋为i
                    //更新leftmost
                    leftmost = i;
                } else {
                    int j = stack.pop();
                    if (stack.isEmpty()) {
                        //弹出之后栈空了
                        max = Math.max(max, i - leftmost);
                    } else {
                        //弹出之后栈没空
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;

    }

}
