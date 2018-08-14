import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

public class LeetCode_832 {

    public static void main(String[]arg){
        int [][]a={{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(Arrays.toString(flipAndInvertImage(a)));
    }

    /**
     * 直接根据题意对矩阵进行变换即可
     * @param A
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        //首先进行数组反转
        for (int i=0;i<A.length;i++){
            //进行数组反转
            for (int j=0;j<=(A[i].length/2)-1;j++){
                int temp1=A[i][j];
                A[i][j]=A[i][A[i].length-j-1];
                A[i][A[i].length-j-1]=temp1;
            }
        }
        //进行数组元素取反
        for(int i=0;i<A.length;i++){
            for (int j=0;j<A[i].length;j++){
                if(A[i][j]==0){
                    A[i][j]=1;
                }else {
                    A[i][j]=0;
                }
            }
        }
        return A;
    }

}
