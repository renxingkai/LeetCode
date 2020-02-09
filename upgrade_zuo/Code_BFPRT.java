package upgrade_zuo;

/**
 * 1)数组N每个小部分分为5
 * 2)每个小数组中进行排序
 * 3)取出每个小数组中的中位数，成为新数组 N/5
 * 4)递归调用BFPRT(以上过程)
 * 5)选出最终数为 X
 * 6)如果X没命中，左右两边只走一侧,左部分最多T(7/10)，右部分最多T(7/10)
 *
 * /**
 *  * TOP K 问题 (第N小、第N大)
 *  * 时间复杂度为 O(n), 稳定的 O(n)
 *  * <p>
 *  * 思路 : 1. 分组, 相邻的5个数一组, 把数组arr分为多个组, 剩余不足5个的数单独成一组    O(1)
 *  * 2. 组内排序, 每组5个数之间排序, 跨组不排序                                 O(N)
 *  * 3. 把每个组中位数取出来构成新数组, 长度 N/5                                O(N)
 *  * 4. 递归调用 BFPRT 算法, 目的是找到新数组的中位数                           T(N/5)
 *  * 5. 用新数组的中位数作为枢轴 pivot 去 partition                            O(N)
 *  * 6. 如果命中直接返回, 没命中根据 pivot 判断走左边还是走右边                 T(7N/10)
 *  * 总的时间复杂度 = T(N/5) + T(7N/10) + O(N) = O(N)
 *
 *  */

public class Code_BFPRT {
    /**
     * 得到最小的第K个数
     *
     * @param arr
     * @param K
     * @return
     */
    public static int getMinKthByBFPRT(int[] arr, int K) {
        int[] copyArr = copyArray(arr);
        return bfprt(copyArr, 0, copyArr.length - 1, K - 1);
    }

    /**
     * 在begin 和end上求第i小的数
     *
     * @param arr
     * @param begin
     * @param end
     * @param i
     * @return
     */
    private static int bfprt(int[] arr, int begin, int end, int i) {
        if (begin == end) {
            return arr[begin];
        }
        //中位数数组中求划分值
        int pivot = medianOfMedians(arr, begin, end);
        //划分范围
        //使用pivot，将arr数组中小于pivot放左边，大于pivot放右边，等于pivot放中间
        int[] pivotRange = partition(arr, begin, end, pivot);
        //pivotRange[0]为最左的位置，pivotRange[1]为最右的位置
        if (i >= pivotRange[0] && i <= pivotRange[1]) {
            //如果i命中了K，直接返回
            return arr[i];
        } else if (i < pivotRange[0]) {
            //走左边
            return bfprt(arr, begin, pivotRange[0] - 1, i);
        } else {
            //走右边
            return bfprt(arr, pivotRange[1] + 1, end, i);
        }
    }

    /**
     * 等于放中间，小于放左边，大于放右边
     *
     * @param arr
     * @param begin
     * @param end
     * @param pivotValue
     * @return
     */
    private static int[] partition(int[] arr, int begin, int end, int pivotValue) {
        int small = begin - 1;
        int cur = begin;
        int big = end + 1;
        while (cur != big) {
            if (arr[cur] < pivotValue) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivotValue) {
                swap(arr, cur, --big);
            } else {
                cur++;
            }
        }
        int[] range = new int[2];
        //等于区域的最左边
        range[0] = small + 1;
        //等于区域的最右边
        range[1] = big - 1;
        return range;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * 求中位数
     *
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    private static int medianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        //中位数组成的数组
        int[] mArr = new int[num / 5 + offset];
        for (int i = 0; i < mArr.length; i++) {
            //每个arr数组中的小分组的开始和结束位置
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
        }
        return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);
    }

    private static int getMedian(int[] arr, int begin, int end) {
        insertSort(arr, begin, end);
        int sum = end + begin;
        int mid = (sum / 2) + (sum % 2);
        return arr[mid];

    }

    /**
     * 插入排序
     *
     * @param arr
     * @param begin
     * @param end
     */
    private static void insertSort(int[] arr, int begin, int end) {
        for (int i = begin + 1; i != end + 1; i++) {
            for (int j = i; j != begin; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    private static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }




    public static void main(String[] args) {
        System.out.println(getMinKthByBFPRT(new int[]{3,1,2,2,4,0,4},2));
    }

}
