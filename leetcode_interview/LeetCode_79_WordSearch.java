package leetcode_interview;

public class LeetCode_79_WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        boolean[][] used = new boolean[board.length][board[0].length];
        //去遍历访问数组
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (existHelper(board, used, word.toCharArray(), 0, col, row)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existHelper(char[][] board, boolean[][] used, char[] word, int idx, int col, int row) {
        if (idx == word.length) {
            //遍历完了，返回true
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >=board[0].length) {
            //越界
            return false;
        }
        if (used[row][col] == true || board[row][col] != word[idx]) {
            //没匹配上
            return false;
        }
        //在使用了[row][col]后，要标记已经用过
        used[row][col] = true;
        //下
        boolean exist = existHelper(board, used, word, idx + 1, col + 1, row);
        if (exist) {
            return true;
        }
        //上
        exist = existHelper(board, used, word, idx + 1, col - 1, row);
        if (exist) {
            return true;
        }
        //右
        exist = existHelper(board, used, word, idx + 1, col, row + 1);
        if (exist) {
            return true;
        }
        //左
        exist = existHelper(board, used, word, idx + 1, col, row - 1);
        if (exist) {
            return true;
        }
        //回溯之后修改下
        used[row][col] = false;
        return false;
    }


}
