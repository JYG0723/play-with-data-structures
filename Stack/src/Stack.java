/**
 * @author Ji YongGuang.
 * @date 17:53 2018/4/17.
 */
public interface Stack<E> {

    /**
     * 获取当前栈元素数量
     *
     * @return
     */
    int getSize();

    /**
     * 判断当前栈是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 向栈中添加一个元素
     *
     * @param e
     */
    void push(E e);

    /**
     * 从栈中删除一个元素
     *
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return
     */
    E peek();
}
