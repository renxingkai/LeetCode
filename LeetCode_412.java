import java.util.ArrayList;
import java.util.List;

public class LeetCode_412 {

    public static void main(String[] arg) {

    }


    public static List<String> fizzBuzz(int n) {
        List<String> res=new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i%3==0&&i%5==0){
                res.add("FizzBuzz");
                continue;
            }
            if (i%3==0){
                res.add("Fizz");
                continue;
            }
            if (i%5==0){
                res.add("Buzz");
                continue;
            }
            res.add(String.valueOf(i));
        }
        return res;
    }


}
