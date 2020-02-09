public class LeetCode_404 {

    public static void main(String[] arg) {

    }

    public static int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        } else if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
}



