package loadoffer;

import java.util.HashMap;

public class MoreThanHalfNum_Solution {

    public static void main(String[] args) {

    }

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (result.containsKey(array[i])) {
                result.put(array[i], result.get(array[i]) + 1);
            } else {
                result.put(array[i], 1);
            }
            if (result.get(array[i]) > array.length / 2) {
                return array[i];
            }
        }
        return 0;
    }
}
