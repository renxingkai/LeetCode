package offer_I;

import java.util.ArrayList;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}


public class GetNext {
    public static void main(String[] args) {

    }


    //保存中序遍历的结果
    ArrayList<TreeLinkNode> res=new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode root=pNode;
        //先找到根
        while (root.next!=null){
            root=root.next;
        }
        //中序遍历
        InOrder(root);
        for (int i=0;i<res.size();i++){
            if (pNode==res.get(i)){
                return i==res.size()-1?null:res.get(i+1);
            }
        }
        return null;
    }

    private void InOrder(TreeLinkNode root) {
        if(root!=null){
            InOrder(root.left);
            res.add(root);
            InOrder(root.right);
        }
    }
}
