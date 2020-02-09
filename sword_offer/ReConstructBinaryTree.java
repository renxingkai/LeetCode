package loadoffer;

//https://blog.csdn.net/qq_28081081/article/details/80740057
public class ReConstructBinaryTree {


    public static void main(String[] args) {

    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if (startPre>endPre||startIn>endIn){
            return null;
        }
        //先序遍历的开始位置
        TreeNode root=new TreeNode(pre[startPre]);
        for (int i=startIn;i<=endIn;i++){
            if (in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }

}
