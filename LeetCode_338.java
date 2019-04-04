public class LeetCode_338 {

    public static void main(String[] arg) {

    }

    //法一：使用内建函数，runtime为O(n*sizeof(integer))，不是最优解。
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[1];
        }
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }

    //法二：时间最优，runtime为O(n)，通过右移一位得到之前的结果f[i>>1]，再加上最后一位是0/1即可。
    public int[] countBits1(int num) {
        int[] arr = new int[num+1];
        arr[0] = 0;
        for(int i=1;i<=num;i++){
            arr[i] = arr[i&(i-1)]+1;///数i中1的位数，与前面的i&(i-1)中1的位数有关，为i&(i-1)中1的位数+1；
        }
        return arr;
    }


}
