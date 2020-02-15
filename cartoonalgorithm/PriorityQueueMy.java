package cartoonalgorithm;

import java.util.Arrays;

/**
 * 自己实现优先队列
 */
public class PriorityQueueMy {

    private int[] array;
    private int size;

    public PriorityQueueMy() {
        array = new int[32];//队列初始长度是32
    }

    /**
     * 入队
     *
     * @param key
     */
    public void enQueue(int key) {
        //队列长度超出范围，扩容
        if (size > array.length) {
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    public int deQueue() throws Exception {
        if (size < 0) {
            throw new Exception("队列为空");

        }
        //获取堆顶元素
        int head = array[0];
        //让最后一个元素移动到堆顶
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    /**
     * 下沉调整 大根堆
     */
    private void downAdjust() {
        //temp保存父节点的值,用于最后的赋值
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;
        while (childIndex < size) {
            if (childIndex + 1 < size && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            //父节点大于任一子节点，break
            if (temp > array[childIndex]) {
                break;
            }
            //进行交换
            array[childIndex] = array[parentIndex];
            parentIndex = childIndex;
            childIndex = childIndex * 2 + 1;

        }
        array[childIndex] = temp;
    }

    /**
     * 上浮调整 大根堆
     * childIndex往上浮
     */
    private void upAdjust() {
        int childIndex = size - 1;
        int parentIndex = (childIndex) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = parentIndex / 2;//parent往上走
        }
        array[childIndex] = temp;
    }

    private void resize() {
        //队列容量翻倍
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    public static void main(String[] args) throws Exception {
        PriorityQueueMy priorityQueueMy = new PriorityQueueMy();
        priorityQueueMy.enQueue(3);
        priorityQueueMy.enQueue(5);
        priorityQueueMy.enQueue(10);
        priorityQueueMy.enQueue(2);
        priorityQueueMy.enQueue(7);
        System.out.println("出队元素:" + priorityQueueMy.deQueue());
        System.out.println("出队元素:" + priorityQueueMy.deQueue());
    }

}
