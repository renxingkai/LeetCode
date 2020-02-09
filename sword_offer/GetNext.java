package loadoffer;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
//https://blog.csdn.net/qq_41901915/article/details/90229704
public class GetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        //第一种情况，有右子树，然后就一直找右子树的左，直到为null
        if(pNode.right!=null){
            TreeLinkNode resultNode1=pNode.right;
            while (resultNode1.left!=null){
                resultNode1=resultNode1.left;
            }
            return resultNode1;
        }else {
            //第二种情况，没有右子树，那么就得找父节点，当父节点的左等于当前节点也就找到了
            //这种情况较难想象
            while (pNode.next!=null){
                TreeLinkNode resultNode2=pNode.next;
                if (resultNode2.left==pNode){
                    return resultNode2;
                }
                pNode=pNode.next;
            }
        }
        return null;
    }

}
