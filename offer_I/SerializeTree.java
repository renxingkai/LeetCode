package offer_I;

import java.text.DecimalFormat;

public class SerializeTree {

    String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + Serialize(root.left) + "," + Serialize(root.right);
    }


    int index = -1;

    TreeNode Deserialize(String str) {
        String[] splits = str.split(",");
        index++;
        if (index == splits.length) {
            return null;
        }
        TreeNode treeNode = null;
        if (!splits[index].equals("#")) {
            //还没找到根
            treeNode = new TreeNode(Integer.parseInt(splits[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        return treeNode;
    }


}
