package loadoffer;

public class GetNumberOfK {
    public static void main(String[] args) {

    }
    //最简单方法
    public int GetNumberOfK2(int [] array , int k) {
        if (array==null||array.length==0){
            return 0;
        }
        int times=0;
        for (int i=0;i<array.length;i++){
            if (array[i]==k){
                times++;
            }
        }
        return times;
    }

    //快排思路
    public int GetNumberOfK(int [] array , int k) {
        return binarySearch(array,k+0.5)-binarySearch(array,k-0.5);
    }

    public int binarySearch(int[] array, double v) {

        int i=0;
        int j=array.length-1;
        int mid=0;
        while (i<=j){
            mid=(i+j)/2;
            if (array[mid]>v){
                j=mid-1;
            }else {
                i=mid+1;
            }
        }
        return i;

    }

}
