package leetcode;

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int loc = 1; loc < s.length(); loc++) {
            char ch = s.charAt(loc);
            if (!stack.isEmpty()) {
                if ((stack.peek() == '{' && ch == '}') ||
                        (stack.peek() == '[' && ch == ']') ||
                        (stack.peek() == '(' && ch == ')')) {
                    stack.pop();
                    continue;
                }else if (ch=='}'||ch==']'||ch==')'){
                    break;
                }
            }
            stack.push(ch);
        }
        return stack.isEmpty();
    }

}
