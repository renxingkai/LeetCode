public class LeetCode_617 {

    public static void main(String[]arg){
        
    }

    /**
     * 阅读完题目之后分析的结果是，
     * 在这个树融合的过程中，
     * 每个位置上的节点的融合相对于其他位置的节点而言是独立的，
     * 也就是说我只要便利每一个位置，
     * 将这个位置上两棵树的节点融合就可以了，不用管其他任何事情。
     * 那么要遍历这两棵树的方法有前序，中序和后序。
     * 但由于我们这里并不需要输出每个节点的值，所以用哪个顺序关系并不大，
     * 只是要借鉴这几种遍历方法的递归思想而已。当我们拿到当前位置时，
     * 我们首先考虑当前位置的两个节点是否需要融合，即如果两个节点都非空则需要融合。
     * 如果不需要融合，那么我们只需要返回非空的那个节点即可。
     * 如果需要融合，那么融合后得到新节点的val我们是很容易确定的，通过相加即可。
     * 新节点的左右节点的融合呢，同样交给这个mergeTree的函数来完成，在确定了新节点的val后，
     * 这个融合问题就可以看作t1和t2当前位置节点的左子树融合以及右子树融合的问题啦。
     * @param t1
     * @param t2
     * @return
     */
    public static   TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null){
            return null;
        }else if(t1==null){
            return t2;
        }else if(t2==null){
            return t1;
        }else{
            TreeNode treeNode=new TreeNode(t1.val+t2.val);
            treeNode.left=mergeTrees(t1.left, t2.left);
            treeNode.right=mergeTrees(t1.right, t2.right);
            return treeNode;
        }

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}