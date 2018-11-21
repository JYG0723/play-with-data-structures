import java.util.Objects;

/**
 * @author Ji YongGuang.
 * @date 20:45 2018/4/16.
 * 自定义数组封装类
 */
@SuppressWarnings("ALL")
public class Array<E> {

    /**
     * 元素容器，数组
     */
    private E[] data;
    /**
     * 当前数组元素个数，无值指向0,数组size前都是无效数据
     */
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    /**
     * 获取当前数组中元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量大小
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 所有元素后添加一个元素
     * 由于底层调用add函数，有可能触发resize函数，所有按最坏情况考虑。
     * 复杂度O(n)
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在指定位置插入一个元素
     * O(n)
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Array - add - Required index > 0 && index < data.size");
        }

        // 0.75
        if (size >= data.length - (data.length >> 2)) {
            resize(data.length << 1);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 所有元素前插入一个元素
     * O(n)
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 获取index索引位置的元素
     * O(n)
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    /**
     * 修改index索引位置的元素值为e
     *
     * @param index
     * @param e
     * @return
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否含有元素e
     * O(n)
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在返回-1
     * O(n)
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index处元素，返回删除的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        E res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        // 释放无效对象
        size--;
        data[size] = null;

        /*
         需要考虑容量不能为0 即 data.length != 1
         我们不需要考虑 data.length / 2 == 0 时size是多少这么多，只要知道 size == data.length / 4 时会触发缩容
            条件，而我们再给它加一层判断条件即可。即特殊情况不需要再触发缩容
          */
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length >> 1);
        }
        return res;
    }

    /**
     * 从数组中删除头元素，并返回值
     * O(n)
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除尾元素，并返回值
     * 由于底层调用remove函数，有可能触发resize函数，所有按最坏情况考虑。
     * 复杂度O(n)
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e，如果e存在的话
     *
     * @param e
     */
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * 统计元素数
     *
     * @param e
     * @return
     */
    public int countElement(E e) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i], e)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 删除整个容器中的元素e
     *
     * @param e
     * @return
     */
    public boolean removeAllElement(E e) {
        /*
           错误逻辑
           无法将index都记录到list中，因为每删一次元素，另一个匹配的e的index都将改变。
        List<Integer> indexs = findAll(e);
        for (int i = 0; i < indexs.size(); i++) {
            remove(indexs.get(i));
        }
        return true;*/
        int count = 0;
        int countE = countElement(e);
        while (find(e) != -1) {
            count++;
            removeElement(e);
        }

        if (count == countE) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder dataRes = new StringBuilder();
        dataRes.append(String.format("Array: size = %d , capacity = %d\n ", size, data.length));
        dataRes.append("[");
        for (int i = 0; i < size; i++) {
            dataRes.append(data[i]);
            if (i != size - 1) {
                dataRes.append(",");
            }
        }
        dataRes.append("]");
        return dataRes.toString();
    }

    /**
     * 将数组空间的容量变成newCapacity大小
     * O(n)
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        /*for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }*/
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
