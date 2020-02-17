package cartoonalgorithm;

/**
 * 在一个未排序的数组中，找到排序后相邻元素最大差值
 */
public class GetMaxSortedDistance {

    public static class Bucket {
        Integer max;
        Integer min;
    }

    /**
     * 使用桶排序的思维
     * 统计出每一个桶的最大值 和这个桶右侧非空桶的最小值的差
     * 数值最大的差即为原数组排序后的相邻最大差值
     *
     * @param array
     * @return
     */
    public static int getMaxSortedDistance(int[] array) {
        //1.得到数列的最大值与最小值
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] > min) {
                min = array[i];
            }
        }
        int d = max - min;
        //如果max==min，说明数组中所有元素都相等
        if (d == 0) {
            return 0;
        }

        //2.初始化桶
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }

        //3.遍历原始数组，确定每个桶的最大值和最小值
        for (int i = 0; i < array.length; i++) {
            //确定数组元素所归属的桶下标
            int index = ((array[i] - min) * (bucketNum - 1) / d);
            if (buckets[index].min == null || buckets[index].min > array[i]) {
                //更新最小值
                buckets[index].min = array[i];
            }
            if (buckets[index].max == null || buckets[index].max < array[i]) {
                //更新最大值
                buckets[index].max = array[i];
            }
        }
        //4.遍历桶，找到最大差值
        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null) {
                //桶为空,continue
                continue;
            }
            if (buckets[i].min - leftMax > maxDistance) {
                maxDistance = buckets[i].min - leftMax;
            }
            //保存左侧最大值
            leftMax = buckets[i].max;
        }
        return maxDistance;
    }

}
