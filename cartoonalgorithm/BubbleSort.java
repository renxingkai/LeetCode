package cartoonalgorithm;

import java.util.Arrays;

public class BubbleSort {

    /**
     * 最原始冒泡排序
     *
     * @param array
     */
    public static void sort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 冒泡排序的优化
     * //如果整个一轮并未发生交换，则证明已经是有序的了
     *
     * @param array
     */
    public static void sortOpt(int array[]) {

        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;//每次交换前都是true
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                //如果未发生交换，直接退出
                break;
            }
        }
    }


    /**
     * 优化2
     * 对数列有序区进行界定
     * @param array
     */
    public static void sortOpt2(int array[]) {
        //对数列有序区的界定
        int sortArea=array.length-1;
        for (int i=0;i<array.length-1;i++){
            boolean flag=true;
            for (int j=0;j<sortArea;j++){
                //只排无序区域
                if (array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    //记录交换过得位置
                    sortArea=j;
                    //改变flag
                    flag=false;
                }
            }
            if (flag){
                break;
            }
        }
    }



    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }


}
