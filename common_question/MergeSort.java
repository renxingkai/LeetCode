package common_question;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        System.out.println(Arrays.toString(arr));
        MergeSort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //    归并时间复杂度O(N*logN)，额外空间复杂度O(N)，稳定
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
//        如果左边界小于右边界执行，否则返回
        if (l < r) {
            int mid = (l + r) / 2;
//            采用分治
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
//            将左右排好序的数组重新排好序
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //添加上剩余的元素
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        //将辅助数组中的值全部复制回去arr中
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
    }
}