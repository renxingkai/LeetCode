public class LeetCode_905 {


    public static void main(String[] arg) {

    }

    /**
     * 将偶数放于前面，奇数放于后面
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int i=0;
        int j=A.length-1;
        for (int x:A){
            if (x%2==0){
                result[i++]=x;
            }else {
                result[j--]=x;
            }
        }
        return result;
    }

}
