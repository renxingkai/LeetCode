package upgrade_zuo;

import java.util.*;

public class Code_BuildingOutline {

    public static class Node {
        public boolean isUp;
        public int posi;
        public int h;

        public Node(boolean isUp, int posi, int h) {
            this.isUp = isUp;
            this.posi = posi;
            this.h = h;
        }
    }


    public static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            //位置小的排在前面
            if (o1.posi != o2.posi) {
                return o1.posi - o2.posi;
            }
            if (o1.isUp != o2.isUp) {
                return o1.isUp ? -1 : 1;
            }
            return 0;
        }
    }


    public List<List<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        //一个大楼拆成两个信息
        Node[] nodes = new Node[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            //上
            nodes[i * 2] = new Node(true, buildings[i][0], buildings[i][2]);
            //下
            nodes[i * 2 + 1] = new Node(false, buildings[i][1], buildings[i][2]);
        }
        //排序
        Arrays.sort(nodes, new NodeComparator());
        //高度Map
        TreeMap<Integer, Integer> htMap = new TreeMap<>();
        //出现当前位置的最大高度记下来
        TreeMap<Integer, Integer> pmMap = new TreeMap<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].isUp) {
                //当前是加高度
                if (!htMap.containsKey(nodes[i].h)) {
                    //高度是第一次出现
                    htMap.put(nodes[i].h, 1);
                } else {
                    //不是第一次出现，则Map中高度加一
                    htMap.put(nodes[i].h, htMap.get(nodes[i].h) + 1);
                }
            } else {
                //减高度
                if (htMap.containsKey(nodes[i].h)) {
                    if (htMap.get(nodes[i].h) == 1) {
                        htMap.remove(nodes[i].h);
                    } else {
                        htMap.put(nodes[i].h, htMap.get(nodes[i].h) - 1);
                    }
                }
            }
            //收集每个位置的最大高度
            if (htMap.isEmpty()) {
                pmMap.put(nodes[i].posi, 0);
            } else {
                pmMap.put(nodes[i].posi, htMap.lastKey());
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        //之前的高度
        int height = 0;
        for (Map.Entry<Integer, Integer> entry : pmMap.entrySet()) {
            int curPosition = entry.getKey();
            int curMaxHeight = entry.getValue();
            if (height != curMaxHeight) {
                if (height != 0) {
                    //生成轮廓线
                    List<Integer> newRecord = new ArrayList<Integer>();
                    newRecord.add(start);
                    newRecord.add(curPosition);
                    newRecord.add(height);
                    res.add(newRecord);
                }
                start = curPosition;
                height = curMaxHeight;
            }
        }
        return res;

    }


}
