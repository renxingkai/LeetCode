package offer_I;

public class ReConstructBinaryTree {

    public static void main(String[] args) {

    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reCons(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reCons(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        //递归返回的条件
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        //先序遍历第一个即为根
        TreeNode root=new TreeNode(pre[preStart]);
        for (int i=0;i<=inEnd;i++){
            if (in[i]==pre[preStart]){
                root.left=reCons(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
                root.right=reCons(pre,preStart+i-inStart+1,preEnd,in,i+1,inEnd);
            }
        }
        return root;

    }


}
