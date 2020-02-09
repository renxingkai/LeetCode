package upgrade_zuo;

import javafx.util.BuilderFactory;

import java.util.HashMap;

public class Code_LRU {

    public static class Node<V> {
        public V value;
        public Node<V> last;
        public Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }

    public static class NodeDoubleLinkedList<V> {
        Node<V> head;
        Node<V> tail;

        public NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void addNode(Node<V> newNode) {
            if (newNode == null) {
                return;
            }
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                //之前尾的下一个
                this.tail.next = newNode;
                //新节点下一个指向tail
                newNode.last = this.tail;
                //改写尾结点
                this.tail = newNode;
            }
        }


        public void moveNodeToTail(Node<V> node) {
            if (this.tail == node) {
                //node在尾部，直接删除
                return;
            }
            if (this.head == node) {
                //node在头部，
                this.head = node.next;
                this.head.last = null;
            } else {
                //node在中间
                node.last.next = node.next;
                node.next.last = node.last;
            }
            //node上一个指向之前最后一个尾部节点
            node.last = this.tail;
            //node的下一个指向空
            node.next = null;
            //之前最后一个尾结点的next指向node
            this.tail.next = node;
            //最后一个尾结点指向node
            this.tail = node;
        }

        /**
         * 移除头部
         *
         * @return
         */
        public Node<V> removeHead() {
            if (this.head == null) {
                return null;
            }
            Node<V> res = this.head;
            if (this.head == this.tail) {
                //只有一个节点
                this.head = null;
                this.tail = null;
            } else {

                this.head = res.next;
                res.next = null;
                this.head.last = null;
            }
            return res;
        }
    }


    public static class MyCache<K, V> {
        private HashMap<K, Node<V>> keyNodeMap;
        private HashMap<Node<V>, K> nodeKeyMap;
        private NodeDoubleLinkedList<V> nodeList;//支持优先级
        int capacity;

        public MyCache(int capacity) {
            if (capacity < 1) {
                throw new RuntimeException("should be more than 0.");
            }
            this.keyNodeMap = new HashMap<K, Node<V>>();
            this.nodeKeyMap = new HashMap<Node<V>, K>();
            this.nodeList = new NodeDoubleLinkedList<V>();
            this.capacity = capacity;
        }

        public V get(K key) {
            if (this.keyNodeMap.containsKey(key)) {
                //将该key结点放到双向链表尾部
                Node<V> res = this.keyNodeMap.get(key);
                this.nodeList.moveNodeToTail(res);
                return res.value;
            }
            return null;
        }

        public void set(K key, V value) {
            if (this.keyNodeMap.containsKey(key)) {
                //存在此key,修改value值，并移至链表尾,此时优先级最高
                Node<V> node = this.keyNodeMap.get(key);
                node.value = value;
                this.nodeList.moveNodeToTail(node);
            } else {
                Node<V> newNode = new Node<V>(value);
                this.keyNodeMap.put(key, newNode);
                this.nodeKeyMap.put(newNode, key);
                this.nodeList.addNode(newNode);
                if (this.keyNodeMap.size() == this.capacity + 1) {
                    this.removeMostUnusedCache();
                }
            }
        }

        /**
         * 删除最近最久没有使用的节点
         */
        private void removeMostUnusedCache() {
            //拿出优先级最低的头节点
            Node<V> removeNode = this.nodeList.removeHead();
            K removeKey = this.nodeKeyMap.get(removeNode);
            this.nodeKeyMap.remove(removeNode);
            this.keyNodeMap.remove(removeKey);

        }


    }


}
