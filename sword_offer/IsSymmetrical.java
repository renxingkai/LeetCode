package loadoffer;

//https://blog.csdn.net/u011444062/article/details/78797320
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class IsSymmetrical {
    public static void main(String[] args) {

    }

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null || pRoot.left == null && pRoot.right == null) {
            return true;
        }
        return Symmetrical(pRoot.left, pRoot.right);

    }

    boolean Symmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return Symmetrical(left.left, right.right) && Symmetrical(left.right, right.left);
        }
        return false;
    }


}
