package upgrade_zuo;

public class Code_AbstractBinarySearchTree {
    public static class Node {
        Node left;
        Node right;
        Integer value;
    }

    public Node root;

    protected int siez;

    /**
     * 搜索节点
     *
     * @param element
     * @return
     */
    public Node search(int element) {
        Node node = root;
        while (node != null && node.value != null && node.value != element) {
            if (element < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }




}
