package leetcode_interview;

public class LeetCode_74_Searcha2DMatrix {

    /**
     * 两个二分法
     * 先用最后一列的中间的数 与target比较，确定出上下区间
     * 然后再取对应区间的中间的数 ，确定出上下区间，依次，最终存在的话，锁定一行
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null | matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int startRow = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        int row = -1;
        while (startRow + 1 < endRow) {
            //二分每行
            int mid = startRow + (endRow - startRow) / 2;
            if (matrix[mid][endCol] < target) {
                startRow = mid;
            } else {
                endRow = mid;
            }
        }
        //改变二分之后row的行数
        if (matrix[startRow][endCol] >= target) {
            row = startRow;
        } else if (matrix[endRow][endCol] >= target) {
            row = endRow;
        } else {
            return false;
        }
        int start = 0;
        int end = endCol;
        //扫描定位到的那一行
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        } else {
            return false;
        }

    }


}
