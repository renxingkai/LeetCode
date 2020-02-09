import java.util.Arrays;

public class LeetCode_657 {

    public static void main(String[]arg){

        System.out.println(judgeCircle("LL"));
    }

    /**
     * 水平方向定义一个countX，向左+1，向右-1
     * 垂直方向定义一个countY，向上+1,向下-1
     * 如果有构成0的话就成为了一个circle
     * @param moves
     * @return
     */
    public static boolean judgeCircle(String moves) {
        int countX=0;
        int countY=0;
        for(int i=0;i<moves.length();i++){
            char c=moves.charAt(i);
            if(c=='L'){
                countX++;
            }else if(c=='R'){
                countX--;
            }else if(c=='U'){
                countY++;
            }else if(c=='D'){
                countY--;
            }
        }
        return countX==0&&countY==0;
    }


}
