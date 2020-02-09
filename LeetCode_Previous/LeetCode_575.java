import java.util.HashMap;
//https://blog.csdn.net/weixin_40550726/article/details/80632722
public class LeetCode_575 {


    public static void main(String[] arg) {
        distributeCandies(new int[]{1,1,2,2,3,3});
    }

    //思路：当糖果的种类数目大于妹妹应分得的糖果数目时，妹妹所能分得的最大糖果种类数为妹妹应分得的糖果数，反之，则为糖果的种类数。
    public static int distributeCandies(int[] candies) {
        HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();
        //妹妹应分到的糖果数目
        int n=candies.length/2;
        for (int i:candies){
            hashMap.put(i, 1);
        }
        int d=hashMap.size();//糖果的种类数

        if (d>n){
            return n;
        }else {
            return d;
        }
    }


}
