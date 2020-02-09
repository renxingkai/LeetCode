package cartoonalgorithm;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;

class Node {
    public int data;
    public Node next;


    Node(int data) {
        this.data = data;
    }
}

public class ListOperator {
    //头节点指针
    private Node head;
    //尾节点指针
    private Node last;
    //链表实际长度
    private int size;

    /**
     * 链表插入元素
     *
     * @param data  插入元素
     * @param index 插入位置
     * @throws Exception
     */
    public void insert(int data, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围!");
        }
        Node insertNode = new Node(data);
        if (size == 0) {
            //插入头部
            head = insertNode;
            last = insertNode;
        } else if (size == index) {
            //插入尾部
            last.next = insertNode;
            last = insertNode;
        } else {
            //中部插入
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next;
            prevNode.next = insertNode;
            insertNode.next = nextNode;
        }
        size++;
    }

    /**
     * 链表删除元素
     *
     * @param index 删除的位置
     * @return
     * @throws Exception
     */
    public Node remove(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围!");
        }
        Node removeNode = null;
        if (index == 0) {
            //删除头节点
            removeNode = head;
            head = head.next;
        } else if (index == size - 1) {
            //删除尾结点
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        } else {
            //删除中间结点
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next.next;
            removeNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removeNode;
    }

    /**
     * 链表查找元素
     *
     * @param index
     * @return
     * @throws Exception
     */
    public Node get(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围!");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        size--;
        return temp;
    }

    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws Exception {
        ListOperator listOperator = new ListOperator();
        listOperator.insert(3, 0);
        listOperator.insert(7, 1);
        listOperator.insert(9, 2);
        listOperator.insert(5, 3);
        listOperator.insert(6, 1);
        listOperator.remove(0);
        listOperator.output();
    }

}
