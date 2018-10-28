import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_429 {

    public static void main(String[]arg){

    }

    public List<List<Integer>> levelOrder(Node root) {
        // N叉树的遍历
        List<List<Integer>> retList = new ArrayList<>();
        if (root == null) return retList;
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while(!nodeQueue.isEmpty()) {
            List<Integer> layerNodeList = new ArrayList<>();
            int curLayerSize = nodeQueue.size();
            for (int i = 0; i < curLayerSize; i++) {
                Node cur = nodeQueue.poll();
                layerNodeList.add(cur.val);
                if (cur.children != null) {
                    for (Node tmp : cur.children) {
                        nodeQueue.offer(tmp);
                    }
                }
            }
            retList.add(layerNodeList);
        }
        return retList;
    }


}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}