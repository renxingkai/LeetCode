package loadoffer;


public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead==null||pHead.next==null){
            return pHead;
        }
        if (pHead.val==pHead.next.val){
            //当前节点重复
            ListNode pNode=pHead.next;
            while (pNode!=null&&pNode.val==pHead.val){
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode=pNode.next;
            }
            return deleteDuplication(pNode);
        }else {
            // 当前结点不是重复结点
            pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
            return pHead;
        }
    }

    public static void main(String[] args) {

    }

}
