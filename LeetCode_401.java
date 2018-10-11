import java.util.ArrayList;
import java.util.List;

public class LeetCode_401 {

    public static void main(String[] arg) {


    }

    /**
     * 直接遍历所有时间，如果时间转为二进制所含1的个数==num，则将时间添加到List中
     *
     * @param num
     * @return
     */
    public List<String> readBinaryWatch(int num) {
        ArrayList<String> times = new ArrayList<String>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h * 64 + m) == num) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }


}
