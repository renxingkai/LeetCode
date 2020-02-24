package leetcode_interview;

public class LeetCode_48_RotateImage {

    /**
     * 旋转图片90度  不用额外空间
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        //顶端元素
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix.length - 1;
        int n = matrix.length;//一行元素个数
        while (n > 1) {
            //只需交换n-1个元素
            for (int i=0;i<n-1;i++){
                int temp=matrix[top][left+i];
                matrix[top][left+i]=matrix[bottom-i][left];
                matrix[bottom-i][left]=matrix[bottom][right-i];
                matrix[bottom][right-i]=matrix[top+i][right];
                matrix[top+i][right]=temp;
            }
            top++;
            bottom--;
            left++;
            right--;
            n-=2;
        }
    }


}
