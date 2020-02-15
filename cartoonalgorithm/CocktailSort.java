package cartoonalgorithm;

import java.util.Arrays;

public class CocktailSort {

    /**
     * 第一轮从左到右，第二轮从右到左，第三轮从左到右.....
     *
     * @param array
     */
    public static void cocktailSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            //是否有交换标志
            boolean flag = true;
            //从左往右
            for (int j = i; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            //从右往左，也需要重置下flag
            flag = true;
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int []array=new int[]{2,3,4,5,6,7,8,1};
        cocktailSort(array);
        System.out.println(Arrays.toString(array));
    }


}
