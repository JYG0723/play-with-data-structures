/**
 * @author Ji YongGuang.
 * @date 15:03 2018/4/26.
 * 映射接口
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();
}
