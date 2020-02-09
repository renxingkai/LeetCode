package loadoffer;

import java.util.ArrayList;

//https://blog.csdn.net/qq_28081081/article/details/80846128
public class FindNumbersWithSum {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        int i=0;
        int j=array.length-1;
        while (i<j){
            if (array[i]+array[j]==sum){
                result.add(array[i]);
                result.add(array[j]);
                break;
            }
            if (array[i]+array[j]>sum){
                j--;
            }
            if (array[i]+array[j]<sum){
                i++;
            }
        }
        return result;
    }

}
