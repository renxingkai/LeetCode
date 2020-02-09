package leetcode;


//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left, 1), getDepth(root.right, 1));
    }

    private int getDepth(TreeNode left, int i) {
        if (left == null) {
            return i;
        }
        return Math.max(getDepth(left.left, i + 1), getDepth(left.right, i + 1));
    }

}
