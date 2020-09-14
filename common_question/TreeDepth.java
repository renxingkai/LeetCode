package common_question;

import sun.reflect.generics.tree.Tree;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class TreeDepth {


    public int TreeDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftDepth= TreeDepth(root.left);
        int rightDepth=TreeDepth(root.right);
        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }

}
