package offer_I;

import java.util.Stack;

public class KthNode {
    /**
     * 前序遍历
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRoot;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (--k <= 0) {
                    return cur;
                }
                cur = cur.right;
            }
        }
        return null;
    }
}
