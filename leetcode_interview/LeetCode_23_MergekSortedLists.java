package leetcode_interview;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode_23_MergekSortedLists {


    class NodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }

    /**
     * 使用小根堆解决
     * 不断对每个数组push 元素
     * pop元素
     * 然后串在一起
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        if (lists == null || lists.length == 0) {
            return dummy.next;
        }
        int size = lists.length;
        NodeComparator cmp = new NodeComparator();
        //小根堆
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(cmp);
        for (int i = 0; i < size; i++) {
            if (lists[i] != null) {
                //优先队列中添加listnode节点列表
                //添加的是每个listnode列表最开始的元素
                priorityQueue.add(lists[i]);
            }
        }
        while (priorityQueue.size() != 0) {
            //弹出一个节点，一定是最小的元素
            ListNode node = priorityQueue.poll();
            //串起来最小节点
            current.next = node;
            current = current.next;
            if (node.next != null) {
                //添加最小node下一个节点
                priorityQueue.add(node.next);
            }
        }
        return dummy.next;
    }

}
