package offer_I;

public class IsSymmetrical {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null || (pRoot.left == null && pRoot.right == null)) {
            return true;
        }
        return isSysm(pRoot.left, pRoot.right);
    }

    private boolean isSysm(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return isSysm(left.left, right.right) && isSysm(left.right, right.left);
        }
        return false;
    }

}
