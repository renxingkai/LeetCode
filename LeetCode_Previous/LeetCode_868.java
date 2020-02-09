public class LeetCode_868 {

    //https://blog.csdn.net/GZY_BUPT/article/details/81488287
    public static void main(String[] arg) {

    }


    public static int binaryGap(int N) {
        int[] arrNum = new int[32];//初始化一个新的数组 ，默认长度为32位
        int bit = 0;//为1的位
        int cnt = 0;//间距
        /**
         * N >> i 是将N转为二进制右移i位后的值，再&1则是判断哪一个位置为1.
         */
        for (int i = 0; i < arrNum.length; i++) {
            if (((N >> i) & 1) != 0) {
                ////判断转为二进制哪个位置的值为1
                //第i位的值为1
                arrNum[bit++] = i;
            }
        }
        for (int i = 0; i < bit; i++) {
            cnt = Math.max(arrNum[i + 1] - arrNum[i], cnt);
        }
        return cnt;
    }

}
