/**
 * @author Ji YongGuang.
 * @date 19:41 2018/4/18.
 */
public class LoopQueue<E> implements Queue<E> {

    private E data[];
    /**
     * front 指向队列首元素位置 | tail 指向队列尾元素的下一空位置
     */
    private int front, tail;
    /**
     * 队列中元素个数
     */
    private int size;

    public LoopQueue(int capacity) {
        // 满足用户期望,满足循环队列
        data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue() {
        // 默认capacity
        this(10);
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * 队列实际容量
     *
     * @return
     */
    public int getCapacity() {
        // 为了循环队列 舍弃一块内存
        return data.length - 1;
    }

    /**
     * O(1) 均摊
     *
     * @param e
     */
    @Override
    public void enQueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(data.length << 1);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 0(1) 均摊
     * @return
     */
    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        E e = data[front];
        // 释放索引指向对象
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size <= getCapacity() / 4 && data.length / 2 != 0) {
            resize(data.length >> 1);
        }
        return e;
    }

    /**
     * 队列扩容|缩容
     *
     * @param newCapacity 期望容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            // 原队列数组的front 到新队列数组的头处
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = ++i % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> arrayQueue = new LoopQueue<>();

        for (int i = 0; i < 10; i++) {
            arrayQueue.enQueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 2) {
                arrayQueue.deQueue();
                System.out.println(arrayQueue);
            }
        }
    }
}
