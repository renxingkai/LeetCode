import java.util.ArrayList;

public class LeetCode_283 {


    public static void main(String[] arg) {

    }

    /**
     * 统计0出现次数，用arraylist添加非0元素，最后补0
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int size = nums.length;
        int countZeroes = 0;

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            if (nums[i] == 0) {
                countZeroes++;
                continue;
            } else {
                arrayList.add(nums[i]);
            }
        }

        for (int i = 0; i < countZeroes; i++) {
            arrayList.add(0);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            nums[i] = arrayList.get(i);
        }

    }


}
