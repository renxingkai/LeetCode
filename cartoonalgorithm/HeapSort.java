package cartoonalgorithm;

import java.util.Arrays;

/**
 * 1.把无序数组构建二叉堆，需要从小到大排序，则构成最大堆；需要从大到小排序，则构成最小堆
 * 2.循环删除堆顶元素，替换到二叉堆的末尾，调整堆产生新的堆
 */
public class HeapSort {

    public static void heapSort(int[] array) {
        //1.把无序数组构建成最大堆
        for (int i = array.length / 2; i >= 0; i--) {
            downAdjust2(array, i, array.length - 1);
        }
        System.out.println(Arrays.toString(array));
        //2.循环删除堆顶的元素,移到集合的尾部,调整堆产生新的堆顶
        for (int i = array.length - 1; i > 0; i--) {
            //最后一个元素与第一个元素交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            //下沉调整最大堆
            downAdjust2(array, 0, i);
        }
    }

    /**
     * 下沉调整
     * @param array 待调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length 堆的有效大小
     */
    private static void downAdjust2(int[] array, int parentIndex, int length) {

        //temp保存父节点，用于最后赋值
        int temp=array[parentIndex];
        int childIndex=2*parentIndex+1;
        while (childIndex<length){
            //往下找孩子
            if (childIndex+1<length&&array[childIndex+1]>array[childIndex]){
                //转到右孩子
                childIndex++;
            }
            if (temp>=array[childIndex]){
                break;
            }
            //此时childIndex 往上走，走到parent位置
            array[parentIndex]=array[childIndex];
            //parent下来
            parentIndex=childIndex;
            //childIndex再去探究下一个childIndex
            childIndex=childIndex*2+1;
        }
        //parent沉底
        array[parentIndex]=temp;
    }


    public static void main(String[] args) {
        int[]arrs=new int[]{2,5,8,9,1,3,3};
        heapSort(arrs);
        System.out.println("'----------------'");
        System.out.println(Arrays.toString(arrs));
    }

}
