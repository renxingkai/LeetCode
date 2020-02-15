package cartoonalgorithm;

/**
 * 循环队列
 */
public class CircularQueue {

    private int[] array;//队列保存元素
    private int front;//队首
    private int rear;//队尾


    public CircularQueue(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 入队
     *
     * @param element
     */
    public void enQueue(int element) throws Exception {
        //队尾到了队头
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满~");
        }
        //队尾添加新元素
        array[rear] = element;
        //更新队尾
        rear = (rear + 1) % array.length;
    }

    /**
     * 弹出队列
     *
     * @return
     * @throws Exception
     */
    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空!");
        }
        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    public void output() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        CircularQueue circularQueue = new CircularQueue(6);
        circularQueue.enQueue(3);
        circularQueue.enQueue(4);
        circularQueue.enQueue(5);
        circularQueue.enQueue(6);
        circularQueue.enQueue(1);
        circularQueue.deQueue();
        circularQueue.deQueue();
        circularQueue.deQueue();
        circularQueue.enQueue(2);
        circularQueue.enQueue(4);
        circularQueue.enQueue(9);
        circularQueue.output();
    }

}
