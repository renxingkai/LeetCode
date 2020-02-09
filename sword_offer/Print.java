package loadoffer;

import java.util.ArrayList;
import java.util.Stack;

public class Print {


    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res_list = new ArrayList<>();
        int layer = 1;//标记层数
        //s1存奇数节点
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(pRoot);
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        while (!s1.empty() || !s2.empty()) {
            if (layer % 2 != 0) {
                //处理奇数层
                ArrayList<Integer> list = new ArrayList<>();
                while (!s1.empty()) {
                    TreeNode t = s1.pop();
                    if (t != null) {
                        list.add(t.val);
                        s2.push(t.left);
                        s2.push(t.right);
                    }
                }
                if (!list.isEmpty()) {
                    res_list.add(list);
                    layer++;
                }
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                while (!s2.empty()) {
                    TreeNode t = s2.pop();
                    if (t != null) {
                        list.add(t.val);
                        s1.push(t.right);
                        s1.push(t.left);
                    }
                }
                if (!list.isEmpty()) {
                    res_list.add(list);
                    layer++;
                }
            }
        }
        return res_list;
    }


}
