package loadoffer;

public class HasSubtree {

    public static void main(String[] args) {

    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root2 == null) {
            return false;
        }
        if (root1 == null) {
            return false;
        }
        return isSubTree(root1, root2) || isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }
        return false;
    }


}
