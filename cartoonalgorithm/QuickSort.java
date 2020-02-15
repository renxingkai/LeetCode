package cartoonalgorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * * 在每一轮挑选一个基准元素，并让其他比他大的元素移动到数列一边，
 * * 比他小的元素移动到数列另一边
 * * 从而把数列插接为两部分
 */
public class QuickSort {

    //---------------------------双边循环法--------------------------------------

    /**
     * 双边循环法
     *
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void sort(int[] array, int startIndex, int endIndex) {
        //递归结束条件:startIndex>=endIndex
        if (startIndex >= endIndex) {
            return;
        }
        //得到基准元素位置
        int pivotIndex = partition(array, startIndex, endIndex);
        //根据基准元素，分成两部分进行递归排序
        sort(array, startIndex, pivotIndex - 1);
        sort(array, pivotIndex + 1, endIndex);
    }

    /**
     * 分治 双边循环法
     *
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition(int[] array, int startIndex, int endIndex) {

        //取第一个位置的元素作为基准
        int pivot = array[startIndex];
        //左右指针
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            //控制right指针比较并左移
            while (left < right && array[right] > pivot) {
                //比哨兵大则继续左移
                right--;
            }
            //控制left指针并右移
            while (left < right && array[left] <= pivot) {
                //比哨兵小则继续右移
                left++;
            }
            //交换left和right指针所指的元素
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        //pivoit和指针重合点交换
        array[startIndex] = array[left];
        array[left] = pivot;
        return left;
    }
    //---------------------------双边循环法--------------------------------------


    //---------------------------单边循环法--------------------------------------
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivot = partitionV2(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivot - 1);
        quickSort(arr, pivot + 1, endIndex);
    }

    /**
     * 分治
     * 单边循环法
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partitionV2(int[] arr, int startIndex, int endIndex) {
        //取第一个位置作为pivot
        int pivot = arr[startIndex];
        int mark = startIndex;//比pivot小的标志
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                //小于pivot则交换
                mark++;
                int temp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = temp;
            }
        }
        //
        arr[startIndex] = arr[mark];
        //将哨兵元素放到mark
        arr[mark] = pivot;
        return mark;
    }
//---------------------------单边循环法--------------------------------------


    //---------------------------非递归实现-------------------------------------
    public static void quickSort2(int[] arr, int startIndex, int endIndex) {
        //用一个集合栈来代替函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<Map<String, Integer>>();
        //整个数列的起止下标，以哈希的形式入栈
        Map rootParam = new HashMap();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);
        //循环结束条件 栈为空
        while (!quickSortStack.isEmpty()) {
            //栈顶元素出栈,得到起止下标
            Map<String, Integer> param = quickSortStack.pop();
            //得到基准元素位置
            int pivotIndex = partitionV2(arr, param.get("startIndex"), param.get("endIndex"));
            //根据基准元素分成两部分,把每一部分的起止下标入栈
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftparam = new HashMap<String, Integer>();
                leftparam.put("startIndex", param.get("startIndex"));
                leftparam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftparam);
            }
            if (param.get("endIndex") > pivotIndex + 1) {
                Map<String, Integer> rightparam = new HashMap<String, Integer>();
                rightparam.put("startIndex", pivotIndex + 1);
                rightparam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightparam);
            }

        }

    }


    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


}
