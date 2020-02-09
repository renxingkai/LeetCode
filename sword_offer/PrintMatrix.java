package loadoffer;

import java.util.ArrayList;

public class PrintMatrix {

    public static void main(String[] args) {

    }

    ArrayList a = new ArrayList();

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;//矩阵行数
        int dC = matrix[0].length - 1;//矩阵列数
        while (tR <= dR && tC <= dC) {
            //左上边界最多到达右下边界 用于判断是否还是剥圈打印
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
        return a;

    }

    private void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        //先判断是否只是一横行 如果是 打印该横行的列（通常用于内圈）
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                a.add(matrix[tR][i]);
            }
        } else if (tC == dC) {
            //再判断是否只是一竖列 如果是 打印该横行的列（通常用于内圈
            for (int i = tR; i <= dR; i++) {
                a.add(matrix[i][tR]);
            }
        } else {
            //用2个变量储存 用于判断当前位置
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                a.add(matrix[tR][curC]);
                curC++;
            }
            while (curR!=dR){
                a.add(matrix[curR][dC]);
                curR++;
            }
            while (curC!=tC){
                a.add(matrix[dR][curC]);
                curC--;
            }
            while (curR!=tR){
                a.add(matrix[curR][tC]);
                curR--;
            }

        }
    }

//    链接：https://www.nowcoder.com/questionTerminal/9b4c81a02cd34f76be2659fa0d54342a?f=discussion
//    来源：牛客网

//else {
//        int curC=tC;用2个变量储存 用于判断当前位置
//        int curR=tR;
//        while(curC!=dC){      当前位置未到达当前行的最右列 --》往右去
//            a.add(m[tR][curC]);
//            curC++;
//        }
//        while(curR!=dR){      当前位置未到达当前列的最底行 --》往下去
//            a.add(m[curR][dC]);
//            curR++;
//        }
//        while(curC!=tC){      当前位置未到达当前行的最左列 --》往左去
//            a.add(m[dR][curC]);
//            curC--;
//        }
//        while(curR!=tR){      当前位置未到达当前列的最顶行 --》往上去
//            a.add(m[curR][tC]);
//            curR--;
//        }
//    }

}
