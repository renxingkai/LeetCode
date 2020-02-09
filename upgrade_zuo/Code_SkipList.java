package upgrade_zuo;

import java.util.ArrayList;

/**
 * 跳表
 */
public class Code_SkipList {
    /**
     * 跳表node节点
     */
    public static class SkipListNode {
        public Integer value;
        public ArrayList<SkipListNode> nextNodes;//有几代表了几层  nextNodes[0] 在第0层上， 下一个节点是什么

        public SkipListNode(Integer value) {
            this.value = value;
            nextNodes = new ArrayList<SkipListNode>();
        }


    }


    public static class SkipList {
        SkipListNode head;//巨小
        int maxLevel;//所有数据最大层
        int size;//加进来了多少数据
        static final double PROBABILITY = 0.5;

        public SkipList() {
            size = 0;
            maxLevel = 0;
            head = new SkipListNode(null);
            head.nextNodes.add(null);
        }

        public SkipListNode getHead() {
            return head;
        }

        /**
         * 添加一个数
         *
         * @param newvalue
         */
        public void add(Integer newvalue) {
            if (!contains(newvalue)) {
                size++;
                int level = 0;
                //控制newvalue的level层数
                while (Math.random() < PROBABILITY) {
                    level++;
                }
                while (level > maxLevel) {
                    //巨小层数继续加，直到达到了level层
                    head.nextNodes.add(null);
                    maxLevel++;
                }
                SkipListNode newNode = new SkipListNode(newvalue);
                SkipListNode current = head;
                int levelAll=maxLevel;
                do {
                    if (level>=levelAll){
                        //current可以认为是7
                        current = findNext(newvalue, current, levelAll);
                        //把每一层的下一个值都添加到0位置，从而依次往后挤
                        // 7 10添加8  ，下面一行建立8和10之间的联系
                        newNode.nextNodes.add(0, current.nextNodes.get(level));
                        //7在第level层上，设置newNode
                        current.nextNodes.set(level, newNode);
                    }
                } while (levelAll-- > 0);
            }
        }

        public void delete(Integer deleteValue) {
            if (contains(deleteValue)) {
                SkipListNode deleteNode = find(deleteValue);
                size--;
                int level = maxLevel;
                SkipListNode current = head;
                do {
                    current = findNext(deleteNode.value, current, level);
                    if (deleteNode.nextNodes.size() > level) {
                        current.nextNodes.set(level, deleteNode.nextNodes.get(level));
                    }
                } while (level-- > 0);
            }
        }

        private SkipListNode find(Integer deleteValue) {
            return find(deleteValue, head, maxLevel);
        }


        private SkipListNode find(Integer e, SkipListNode current, int level) {
            do {
                current = findNext(e, current, level);
            } while (level-- > 0);
            return current;
        }


        private SkipListNode findNext(Integer newvalue, SkipListNode current, int level) {
            //当前值的下一个节点
            SkipListNode next = current.nextNodes.get(level);
            while (next != null) {
                Integer value = next.value;
                if (lessThan(newvalue, value)) {
                    //newvalue<value
                    break;
                }
                //newvalue>value
                //往后面的链表找
                current = next;
                next = current.nextNodes.get(level);
            }
            return current;
        }

        private boolean lessThan(Integer newvalue, Integer value) {
            return newvalue.compareTo(value) < 0;
        }

        private boolean contains(Integer newvalue) {
            SkipListNode node = find(newvalue);
            return node != null && node.value != null && equalTo(node.value, newvalue);
        }

        private boolean equalTo(Integer value, Integer newvalue) {
            return value.compareTo(newvalue) == 0;
        }


    }


}
