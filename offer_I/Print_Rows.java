package offer_I;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Print_Rows {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (pRoot==null){
            return res;
        }
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> layer=new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode temp=queue.poll();
                layer.add(temp.val);
                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if (temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            res.add(layer);
        }
        return res;

    }
}
