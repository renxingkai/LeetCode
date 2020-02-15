package cartoonalgorithm;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal_PreMidAft {

    public static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }


    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        //递归建立二叉树
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 先序遍历 递归版本
     *
     * @param node
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        //根左右
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        //左根右
        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        //左右根
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }


    /**
     * 先序遍历 非递归版本，使用栈
     *
     * @param root
     */
    public static void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问左孩子，并入栈
            while (treeNode != null) {
                System.out.println(treeNode.data);
                //入栈
                stack.push(treeNode);
                //访问右节点
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左孩子，则进行弹出
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树的广度优先遍历
     * 使用队列
     *
     * @param root
     */
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //添加到队列中
        queue.offer(root);
        while (!queue.isEmpty()) {
            //取出队首元素
            TreeNode node = queue.poll();
            System.out.println(node.data);
            //队尾添加左右孩子
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]
                {3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历");
        preOrderTraveral(treeNode);
        System.out.println("中序遍历");
        inOrderTraveral(treeNode);
        System.out.println("后序遍历");
        postOrderTraveral(treeNode);
    }

}
