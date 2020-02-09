package loadoffer;

//https://blog.csdn.net/endif6/article/details/82356035
public class Convert {

    public static void main(String[] args) {

    }

    //1、将左子树构成双链表，并返回该链表的头节点(左子树最左边的节点)
    //2、定位到左链表的最后一个节点(左子树最右边的节点)
    //3、如果左子树链表不为空，则将当前root追加到左子树链表后
    //4、将右子树构造成双向链表，并返回链表头结点(右子树最左边的节点)
    //5、如果右子树链表不为空，将右子树链表追加到当前root后
    //6，根据左子树链表是否为空返回的整体双向链表的头节点
    //Convert函数把一个二叉搜索树变成一个有序的双向链表，返回双向链表的头结点，参数root为二叉搜索树的根节点
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        //1、将左子树构造成双链表，并返回该链表头结点left
        TreeNode left = Convert(pRootOfTree.left);
        //2、定位到左子树链表的最后一个节点（左子树最右边的节点）
        TreeNode p = left;//创建一个临时节点P,用来遍历找到左链表的最后一个节点(左子树最右边的节点)，p初始化指向做左子树的根节点
        while (p != null && p.right != null) {
            p = p.right;//最终p为左子树最右边的节点
        }
        //3、如果左子树链表不为空，将当前root追加到左子树链表后
        if (left != null) {
            p.right = pRootOfTree;//左子树链表的最后一个节点p（左子树最右边节点）的右指针指向当前root节点
            pRootOfTree.left = p;//当前root节点的左指针指向左子树链表的最后一个节点p（左子树最右边节点）
        }
        //4、将右子树构造成双链表，并返回该链表的头结点right
        TreeNode right = Convert(pRootOfTree.right);

        //5、如果右子树链表不为空，将右子树链表追加到当前root后
        if (right != null) {//右子树链表不为空
            right.left = pRootOfTree;//右子树链表的头结点right的左指针指向当前root
            pRootOfTree.right = right;//当前root的右指针指向右子树链表的头结点right
        }
        return left != null ? left : pRootOfTree;//根据左子树链表是否为空返回整个双向链表的头指针。

    }
}
