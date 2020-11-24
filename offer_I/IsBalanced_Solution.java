package offer_I;

public class IsBalanced_Solution {

    /**
     * 判断一棵树是不是平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = TreeDepth1(root.left);
        int rightDepth = TreeDepth1(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int TreeDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = TreeDepth1(root.left);
        int rightDepth = TreeDepth1(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }


}
