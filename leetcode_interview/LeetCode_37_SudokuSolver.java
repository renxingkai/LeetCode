package leetcode_interview;

public class LeetCode_37_SudokuSolver {

    /**
     * 递归
     * 回溯法
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        boolean temp = solveSudokuHelper(board, 0, 0);
    }


    public boolean solveSudokuHelper(char[][] board, int row, int col) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        //扫描空的cell,找到第一个需要填数字的位置
        while (row < 9 && col < 9) {
            if (board[row][col] == '.') break;
            if (col == 8) {
                col = 0;
                row++;
            } else col++;
        }
        if (row >= 9) {
            return true;
        }
        //当前填字的下一个位置
        int newRow = row + col / 8;
        int newCol = (col + 1) % 9;
        for (int num = 1; num <= 9; num++) {
            //填数字
            if (isValid(board, row, col, num)) {
                //如果该num可以填进去
                board[row][col] = (char) (num + '0');
                //当前数字填好之后，去找下一个数字是否能找到有效的解
                boolean result = solveSudokuHelper(board, newRow, newCol);
                if (result) {
                    return true;
                }
                //如果下一个数字没能找到有效的数字，则把当前重新设置.，进行回溯
                board[row][col] = '.';//回溯
            }
        }
        return false;
    }


    /**
     * 检查row col位置上的num 是否满足要求，每行、每列、3*3小方框
     *
     * @param board
     * @param row
     * @param col
     * @param num
     * @return
     */
    public boolean isValid(char[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            //检查行和列
            if (board[row][i] == num + '0' || board[i][col] == num + '0') {
                return false;
            }
        }
        //检查方框
        int rowoff = (row / 3) * 3;
        int coloff = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[rowoff + i][coloff + j] == num + '0') {
                    return false;
                }
            }
        }
        return true;
    }

}
