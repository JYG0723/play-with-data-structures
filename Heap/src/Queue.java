/**
 * @author Ji YongGuang.
 * @date 18:40 2018/4/18.
 */
public interface Queue<E> {

    /**
     * 元素入队
     */
    void enQueue(E e);

    /**
     * 元素出队
     *
     * @return
     */
    E deQueue();

    /**
     * 获取当前队列元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 查看对首元素
     *
     * @return
     */
    E getFront();
}
