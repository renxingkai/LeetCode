package loadoffer;

public class HasPath {

    public static void main(String[] args) {

    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length <= 0 || rows < 0 || cols <= 0 || str.length <= 0) {
            return false;
        }
        boolean visited[] = new boolean[rows * cols];
        int[] index = {0};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isPath(matrix, rows, cols, i, j, str, visited, index)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPath(char[] matrix, int rows, int cols, int row, int col, char[] str, boolean visited[], int[] index) {
        if (index[0]==str.length){
            return true;
        }
        boolean flag=false;
        //当前折算原数组位置是rows*cols+cols
        if (row>=0&&row<rows&&col>=0&&col<cols&&!visited[row*cols+col]&&matrix[row * cols + col]==str[index[0]]){
            index[0]++;
            visited[row*cols+col]=true;
            //第一个点是合法的起点之后开始回溯:上下左右进行搜索
            flag = isPath(matrix, rows, cols, row - 1, col, str, visited, index) ||
                    isPath(matrix, rows, cols, row + 1, col, str, visited, index) ||
                    isPath(matrix, rows, cols, row, col - 1, str, visited, index) ||
                    isPath(matrix, rows, cols, row, col + 1, str, visited, index);
            if(!flag) {		//恢复现场
                index[0] --;
                visited[row * cols + col] = false;
            }

        }
        return flag;
    }


}
