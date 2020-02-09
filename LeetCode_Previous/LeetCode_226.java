import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_226 {

    public static void main(String[] arg) {

    }

    /**
     * 递归方法
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        //递归种植的条件
        if (root == null) {
            return null;
        }
        //交换左右叶子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        //递归
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 迭代方法
     *
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        List<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        //不断遍历队列
        //使用队列依次替换两个叶子节点
        while (!queue.isEmpty()) {
            int numberOfNodes = queue.size();
            while (numberOfNodes > 0) {
                //取出队首元素
                TreeNode node = queue.remove(0);
                // push children to the next layer by appending to the end of the list
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                numberOfNodes--;
            }
        }
        return root;
    }


}


////Definition for a binary tree node.
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}
