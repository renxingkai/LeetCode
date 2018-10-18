import java.util.*;

public class LeetCode_414 {

    public static void main(String[] arg) {
        int[] num = new int[]{};
        System.out.println(thirdMax(num));
    }

    //error!  26个样例过了25个 还是复杂度太高
    //利用set进行去重，并且找到第三大元素
    public static int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer tmp = it.next();
            System.out.print(tmp + "\t");
        }

        List<Integer> arrlist = new ArrayList<Integer>(set);

        if (arrlist.size() == 1) {
            return arrlist.get(0);
        }

        if (arrlist.size() == 2) {
            return arrlist.get(1);
        }
        return arrlist.get(arrlist.size() - 3);
    }

    //correct思路：注意小于0的情况。3次遍历数组，分别找出第一大的数，第二大的数，第三大的数。
    public static int thirdMax2(int[] nums) {
        int max = -2147483648, second = -2147483648, third = -2147483648;
        boolean flag = false;
        for (int i : nums) {
            if (i>max){
                max=i;
            }
        }

        for (int i : nums) {
            if (i>max){
                max=i;
            }
        }

        for (int i : nums) {
            if (i<max&i>=second){
                second=i;
            }
        }

        for (int i : nums) {
            if (i<second&i>=third){
                third=i;
                flag=true;
            }
        }

        if (flag){
            return third;
        }else {
            return max;
        }

    }


}
