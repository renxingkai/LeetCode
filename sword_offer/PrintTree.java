package loadoffer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {

    public static void main(String[] args) {

    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        //加入根节点
        layer.add(pRoot);
        int start = 0;
        int end = 1;
        while (!layer.isEmpty()) {
            TreeNode cur = layer.remove();//取出每一层
            layerList.add(cur.val);
            start++;
            if (cur.left != null) {
                layer.add(cur.left);
            }
            if (cur.right != null) {
                layer.add(cur.right);
            }
            if (start == end) {
                end = layer.size();
                start = 0;
                result.add(layerList);
                layerList = new ArrayList<Integer>();
            }
        }
        return result;
    }

}
