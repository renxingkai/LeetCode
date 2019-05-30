import java.util.Arrays;

public class LeetCode_1051 {


    public static void main(String []arg){

    }

    public int heightChecker(int[] heights) {
        int [] orderedHeight=heights.clone();
        Arrays.sort(orderedHeight);
        int count=0;
        for (int i=0;i<heights.length;i++){
            if (heights[i]!=orderedHeight[i]){
                count+=1;
            }else {
                continue;
            }
        }
        return count;
    }
}
