package loadoffer;

import java.util.ArrayList;

public class FindPath {

    public static void main(String[] args) {

    }

    ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //处理为空情况
        if (root == null) {
            return pathList;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == target) {
            pathList.add(new ArrayList<Integer>(path));
        }
        if (root.val <= target && root.left != null) {
            FindPath(root.left, target - root.val);
        }
        if (root.val <= target && root.right != null) {
            FindPath(root.right, target - root.val);
        }
        path.remove(path.size() - 1);//回退父节点
        return pathList;


    }

}
