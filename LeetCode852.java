public class LeetCode852 {

    public static void main(String[]arg){
        int []A={0,2,1,0};
        System.out.println(peakIndexInMountainArray(A));
    }

    /**
     * 直接比较A[i-1]<A[i]&&A[i]>A[i+1]是否成立，成立的话获取索引
     * 否则跳出本次循环
     * @param A
     * @return
     */
    public static int peakIndexInMountainArray(int[] A) {
        int index=0;
        for (int i=1;i<A.length;i++){
            if(A[i-1]<A[i]&&A[i]>A[i+1]){
                index=i;
            }else {
                continue;
            }
        }
        return index;

    }

}
