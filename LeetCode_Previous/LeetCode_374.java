public class LeetCode_374 {

    /**
     * 使用二分查找进行猜数字游戏
     *
     * @param arg
     */
    public static void main(String[] arg) {


    }


    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int result = guess(mid);
            if (result == -1) {
                high = mid - 1;
            } else if (result == 1) {
                low = mid + 1;
            } else if (result == 0) {
                return mid;
            }
        }
        return -1;
    }


}
