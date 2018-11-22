/**
 * @author Ji YongGuang.
 * @date 17:40 2018/11/21.
 * @description
 */
public class LoopQueue_<E> implements Queue<E> {

    private E[] data;
    /* front 指向队首 tail 指向队尾元素的下一个位置 */
    private int front, tail;

    public LoopQueue_(int capacity) {
        this.front = 0;
        this.tail = 0;
        this.data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue_() {
        this(3);
    }

    @Override
    public void enQueue(E e) {
        // 满
        if ((tail + 1) % data.length == front) {
            throw new IllegalArgumentException("满");
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E deQueue() {
        // 空
        if (tail == front) {
            return null;
        }
        E target = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        return target;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public E getFront() {
        return null;
    }

    public static void main(String[] args) {
        LoopQueue_<Integer> loopQueue_ = new LoopQueue_();
        loopQueue_.enQueue(1);
        loopQueue_.enQueue(2);
        loopQueue_.deQueue();
        loopQueue_.enQueue(2);
        loopQueue_.deQueue();
        loopQueue_.enQueue(2);

        loopQueue_.deQueue();
        loopQueue_.enQueue(2);
        loopQueue_.deQueue();
        loopQueue_.enQueue(2);
        System.out.println(loopQueue_.tail);
        System.out.println(loopQueue_.front);
    }
}
