import java.util.Arrays;
import java.util.PriorityQueue;
//https://blog.csdn.net/qq_39370495/article/details/86658463
public class LeetCode_973 {

    public static void main(String[] arg) {

    }


    //    we can maintain a max-heap with size K.
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - (p1[0] * p1[0] + p1[1] * p1[1]));
        for (int[] p : points) {
            //添加点p
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        //返回最终的数组结果
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }

    public int[][] kClosest1(int[][] points, int K) {
        //从小到大排列
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }


}
