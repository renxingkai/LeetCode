package offer_I;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Print {

    /**
     * 之字形打印二叉树
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (pRoot==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> layer=new ArrayList<>();
            for (int i=size-1;i>=0;i--){
                TreeNode temp=queue.poll();
                layer.add(temp.val);
                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if (temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            if (res.size()%2==1){
                Collections.reverse(layer);
            }
            res.add(layer);
        }
        return res;
    }

}
