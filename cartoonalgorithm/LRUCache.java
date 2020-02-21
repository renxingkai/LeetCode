package cartoonalgorithm;

import java.util.HashMap;

public class LRUCache {

    //使用HashMap链表
    public static class Node {
        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public Node pre;
        public Node next;
        public String key;
        public String value;
    }

    private Node head;
    private Node end;
    //缓存存储上限
    private int limit;

    private HashMap<String, Node> hashMap;

    /**
     * 构造函数，初始化
     *
     * @param limit
     */
    public LRUCache(int limit) {
        this.limit = limit;
        hashMap = new HashMap<String, Node>();
    }

    /**
     * 获取访问的节点值
     *
     * @param key
     * @return
     */
    public String get(String key) {
        //获取node
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        //刷新hashmap
        refreshNode(node);
        return node.value;
    }

    /**
     * 添加node
     *
     * @param key
     * @param value
     */
    public void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node == null) {
            //如果key不存在，则进行插入到队尾
            if (hashMap.size() >= limit) {
                String oldkey = removeNode(head);
                hashMap.remove(oldkey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        } else {
            //如果存在，刷新key-value
            node.value = value;
            refreshNode(node);
        }
    }

    /**
     * 删除节点
     *
     * @param key
     */
    public void remove(String key) {
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(node);
    }

    /**
     * 刷新被访问的节点位置
     *
     * @param node
     */
    private void refreshNode(Node node) {
        //如果访问的是尾结点，则无需进行移动
        if (node == end) {
            return;
        }
        //移除节点
        removeNode(node);
        //重新插入节点
        addNode(node);
    }

    /**
     * 尾部插入新节点
     *
     * @param node
     */
    private void addNode(Node node) {
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null) {
            head = node;
        }

    }

    /**
     * 删除节点
     *
     * @param node
     * @return
     */
    private String removeNode(Node node) {
        if (node == head && node == end) {
            //唯一存在的节点
            head = null;
            end = null;
        } else if (node == end) {
            //队尾节点
            end = end.pre;
            end.next = null;
        } else if (node == head) {
            //队首节点
            head = head.next;
            head.pre = null;
        } else {
            //在中间
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }


}
