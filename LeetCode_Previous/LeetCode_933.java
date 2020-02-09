import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_933 {

    private Deque<Integer> deque;

    //https://leetcode.com/problems/number-of-recent-calls/discuss/282480/Java-queue
    public RecentCounter() {
        deque = new ArrayDeque<>();

    }

    public int ping(int t) {
        deque.add(t);
        while (deque.size()>0&&deque.peek()<t-3000){
            deque.remove();
        }
        return deque.size();

    }

}
