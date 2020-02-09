package upgrade_zuo;

import java.sql.Struct;
import java.util.HashMap;

public class Code_LFU {
    public static class Node {
        Integer key;
        Integer value;
        Integer times;
        Node up;
        Node down;

        public Node(int key, int value, int times) {
            this.key = key;
            this.value = value;
            this.times = times;
        }
    }

    public static class LFUCache {

        public static class NodeList {
            Node head;
            Node tail;
            NodeList last;
            NodeList next;

            public NodeList(Node node) {
                head = node;
                tail = node;
            }

            public void addNodeFromHead(Node newNode) {
                //新头down接老头
                newNode.down = head;
                //老头的up接新头
                head.up = newNode;
                //新头变为head
                head = newNode;
            }

            public boolean isEmpty() {
                return head == null;
            }


            public void deleteNode(Node node) {
                //删尾部节点
                if (head == null) {
                    head = null;
                    tail = null;
                } else {
                    if (node == head) {
                        head = head.down;
                        head.up = null;
                    } else if (node == tail) {
                        tail = node.up;
                        tail.down = null;
                    } else {
                        node.up.down = node.down;
                        node.down.up = node.up;
                    }
                }
                node.up = null;
                node.down = null;

            }
        }

        int capacity;//容量
        int size;//目前实际多少个元素
        HashMap<Integer, Node> records;//一个元素，<Key,Value>
        HashMap<Node, NodeList> heads;//任何一个Node,都能查到属于哪个NodeList
        NodeList headList;//整个大的NodeList 结构中，第一个NodeList是谁

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.records = new HashMap<>();
            this.heads = new HashMap<>();
            headList = null;
        }


        public void set(int key, int value) {
            if (records.containsKey(key)) {
                //先查找key所对应的Node是否存在
                Node node = records.get(key);
                node.value = value;
                node.times++;
                //找到Node对应的大链表
                NodeList curNodeList = heads.get(node);
                //大链表中node和上下级关系解耦掉
                move(node, curNodeList);
            } else {
                //没有包含当前的Node(key,value)
                if (size == capacity) {
                    //容量满了
                    Node node = headList.tail;
                    headList.deleteNode(node);
                    //删完之后可能链表中没有东西了，得重新修改
                    modifyHeadList(headList);
                    records.remove(node.key);
                    heads.remove(node);
                    size--;
                }
                Node node = new Node(key, value, 1);
                if (headList == null) {
                    headList = new NodeList(node);
                } else {
                    if (headList.head.times.equals(node.times)) {
                        headList.addNodeFromHead(node);
                    } else {
                        //headList存在，进来过东西
                        if (headList.head.times.equals(node.times)) {
                            //新加的node 挂在已有  NodeList上
                            headList.addNodeFromHead(node);
                        } else {
                            //新加的node 挂在没有  NodeList上，需要重新创建NodeList
                            NodeList newList = new NodeList(node);
                            newList.next = headList;
                            headList.last = newList;
                            headList = newList;
                        }
                    }
                    records.put(key, node);
                    heads.put(node, headList);
                    size++;
                }
            }

        }

        /**
         * 删除了一个node后，是否把整个nodelist都删除
         *
         * @param nodeList
         * @return
         */
        private boolean modifyHeadList(NodeList nodeList) {
            if (nodeList.isEmpty()) {
                if (headList == nodeList) {
                    //仅有一个头节点
                    headList = nodeList.next;
                    if (headList != null) {
                        //新头last赋值为空
                        headList.last = null;
                    }
                } else {
                    nodeList.last.next = nodeList.next;
                    if (nodeList.next != null) {
                        nodeList.next.last = nodeList.last;
                    }
                }
                return true;
            }
            return false;
        }

        /**
         * node来自于老的nodelist，现在要挂到新的nodelist上去
         *
         * @param node
         * @param oldNodeList
         */
        private void move(Node node, NodeList oldNodeList) {
            oldNodeList.deleteNode(node);
            //oldNodeList的上一个nodelist--->preList
            //为true则 之前还有nodelist,为false则前面只有oldNodeList
            NodeList preList = modifyHeadList(oldNodeList) ? oldNodeList.last :
                    oldNodeList;
            NodeList nextList = oldNodeList.next;
            if (nextList == null) {
                //当前的nodelist就是整个大的链表的尾部
                NodeList newList = new NodeList(node);
                if (preList != null) {
                    preList.next = nextList;
                }
                newList.last = preList;
                if (headList == null) {
                    headList = newList;
                }
                heads.put(node, newList);
            } else {
                if (nextList.head.times.equals(node.times)) {
                    //原来key为4，并且在nodelist中存在key=5
                    nextList.addNodeFromHead(node);
                    heads.put(node, nextList);
                } else {
                    //重新新建并连接
                    NodeList newList = new NodeList(node);
                    if (preList != null) {
                        preList.next = newList;
                    }
                    newList.last = preList;
                    newList.next = nextList;
                    nextList.last = newList;
                    if (headList == null) {
                        headList = newList;
                    }
                    heads.put(node, newList);
                }
            }

        }

        public int  get(int key) {
            if (!records.containsKey(key)) {
                return -1;
            }
            Node node = records.get(key);
            node.times++;
            NodeList curNodeList = heads.get(node);
            move(node, curNodeList);
            return node.value;
        }


    }


}
