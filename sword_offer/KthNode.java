package loadoffer;


import com.sun.source.tree.Tree;

import java.util.Stack;

public class KthNode {

    public static void main(String[] args) {

    }

    TreeNode KthNode(TreeNode pRoot, int k) {

        if (pRoot==null||k==0){
            return null;
        }
        Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode node=pRoot;
        s.add(node);//入栈
        while (node.left!=null){
            s.add(node.left);
            node=node.left;
        }
        int num=0;
        while (!s.empty()){
            TreeNode temp=s.pop();
            num++;
            if (num==k){
                return temp;
            }
            if (temp.right!=null){
                temp=temp.right;
                s.add(temp);
                while (temp.left!=null){
                    s.add(temp.left);
                    temp=temp.left;
                }
            }
        }
        return null;

    }


}
