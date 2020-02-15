package cartoonalgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {


    public static double[] bucketSort(double[] array) {
        //1.得到数列的最大值和最小值,计算出差距
        double max = array[0];
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        double d = max - min;

        //2.初始化桶
        int buckedNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>();
        for (int i = 0; i < buckedNum; i++) {
            bucketList.add(new LinkedList<Double>());
        }
        //3.遍历原数组 将每个元素放入桶中
        for (int i = 0; i < array.length; i++) {
            int num = (int) ((array[i] - min) * (buckedNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }
        //4.对每个桶内部进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }
        //5.输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }


}
