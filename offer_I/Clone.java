package offer_I;

import java.util.HashMap;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Clone {


    HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<>();

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        RandomListNode head = pHead;
        while (head != null) {
            RandomListNode temp = getNode(head);
            temp.next = getNode(head.next);
            temp.random = getNode(head.random);
            head = head.next;
        }
        return getNode(pHead);
    }

    private RandomListNode getNode(RandomListNode node) {
        if (node == null) {
            return node;
        }
        if (!hashMap.containsKey(node)) {
            RandomListNode r = new RandomListNode(node.label);
            hashMap.put(node, r);
        }
        return hashMap.get(node);
    }

}
