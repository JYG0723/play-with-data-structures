/**
 * @author Ji YongGuang.
 * @date 21:18 2018/4/25.
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    boolean isEmpty();

    int getSize();
}
