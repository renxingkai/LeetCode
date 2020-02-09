import java.util.ArrayList;
import java.util.List;

/**
 * 此题需要对树进行遍历，并保存叶子结点，然后判断两个树的叶子结点是否相同
 */
public class LeetCode_872 {

    public static void main(String[] arg) {

    }


    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        boolean retBoolean = false;
        List<Integer> leftRootList = new ArrayList<>();
        List<Integer> rightRootList = new ArrayList<>();
        //获取第一个根子节点
        getTreeChild(leftRootList, root1);
        //获取第二个根子节点
        getTreeChild(rightRootList, root2);
        for (int i = 0; i < leftRootList.size(); i++) {
            if (leftRootList.get(i) != rightRootList.get(i)) {
                retBoolean = false;
                break;
            }
        }
        return retBoolean;
    }

    /**
     * 获取叶子结点，并且保存至列表
     *
     * @param list
     * @param root
     */
    public static void getTreeChild(List<Integer> list, TreeNode root) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            if (root.left != null) {
                getTreeChild(list, root.left);
            }
            if (root.right != null) {
                getTreeChild(list, root.right);
            }
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
