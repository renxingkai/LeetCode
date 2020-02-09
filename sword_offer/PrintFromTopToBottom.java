package loadoffer;

import java.util.ArrayList;

public class PrintFromTopToBottom {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> tlist = new ArrayList<Integer>();
        ArrayList<TreeNode> treelist = new ArrayList<TreeNode>();
        if (root == null) {
            return tlist;
        }
        tlist.add(root.val);
        treelist.add(root);
        for (int i = 0; i < treelist.size(); i++) {
            TreeNode node = treelist.get(i);
            if (node.left != null) {
                treelist.add(node.left);
                tlist.add(node.left.val);
            }
            if (node.right != null) {
                treelist.add(node.right);
                tlist.add(node.right.val);
            }
        }
        return tlist;
    }

}
