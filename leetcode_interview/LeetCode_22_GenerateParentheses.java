package leetcode_interview;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_22_GenerateParentheses {

    /**
     * 递归。回溯法
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<String>();
        helper("", res, n, 0, 0);
        return res;
    }

    /**
     * @param curr  当前字符串
     * @param res   记录结果
     * @param n     总的括号数
     * @param left  当前String已有的左括号
     * @param right 当前String已有的反括号
     */
    private void helper(String curr, List<String> res, int n, int left, int right) {
        if (right == n) {
            //反括号已经等于n了
            //满了就添加
            res.add(curr);
            return;
        }
        if (left < n) {
            //当前位置添加正括号
            helper(curr + "(", res, n, left + 1, right);
        }
        if (right < left) {
            //正括号多了，添加反括号
            helper(curr + ")", res, n, left, right + 1);
        }
    }

}
