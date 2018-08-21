/**
 * 直接对数组进行转置
 *  对相对应的元素进行交换
 */
public class LeetCode_867 {

    public static void main(String [] arg){
        int [][]a=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int [][]b=transpose(a);
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[i].length;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }



    }

    public static int[][] transpose(int[][] A) {
        if(A[0].length==0){
            return null;
        }
        int [][]AT=new int[A[0].length][A.length];
        for (int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                AT[j][i]=A[i][j];
            }

        }
        return AT;
    }
}
