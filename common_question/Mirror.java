package common_question;

public class Mirror {
    /**
     * 返回二叉树的镜像
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root==null){
            return;
        }
        TreeNode temp=root.left;
        root.right=root.left;
        root.left=temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
