package cartoonalgorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 二叉堆操作
 */
public class Heap {
    /**
     * 上浮堆调整
     *
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array) {
        //叶节点id
        int childIndex = array.length - 1;
        //父节点id
        int parentIndex = (childIndex - 1) / 2;
        //temp保存插入的叶子结点值，用于最后的赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            //此时childIndex比parent小
            //需要进行小根堆交换
            //但是无需真正交换，单项赋值即可
            array[childIndex] = array[parentIndex];
            //交换parent索引,childIndex往上走
            childIndex = parentIndex;
            //改变parentIndex,继续往父节点找
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉策略
     *
     * @param array
     * @param parentIndex
     * @param length
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        //temp保存父节点,用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = parentIndex * 2 + 1;//左孩子的索引
        while (childIndex < length) {
            //存在左孩子，其实也是存在孩子，一直循环
            //如果存在右孩子，并且右孩子比左孩子更小，则应该让parent与右孩子交换，此时childIndex应该加一
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            if (temp <= array[childIndex]) {
                //父节点已经比孩子节点更小，应该跳出循环
                break;
            }
            //进行沉底交换
            array[childIndex] = array[parentIndex];
            parentIndex = childIndex;
            //向下差在是否还是有孩子
            childIndex = childIndex * 2 + 1;
        }
        array[childIndex] = temp;
    }


    /**
     * 构建堆
     * @param array
     */
    public static void buildHeap(int[]array){
        //从最后一个非叶子节点开始，依次做下沉调整
        for (int i=(array.length-2)/2;i>=0;i--){
            downAdjust(array,i,array.length);
        }

    }


    public static void main(String[] args) {
        int []array=new int[]{1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array=new int[]{7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }

}
