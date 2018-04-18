/**
 * @author Ji YongGuang.
 * @date 18:44 2018/4/18.
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * Constructs a new ArrayQueue.
     */
    public ArrayQueue() {
        array = new Array<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enQueue(E e) {
        array.addLast(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E deQueue() {
        return array.removeFirst();
    }

    /**
     * 获取队列的容量
     *
     * @return
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

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
