/**
 * @author Ji YongGuang.
 * @date 20:45 2018/4/16.
 * 自定义数组封装类
 */
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

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
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
     *
     * @param e
     */
    public void addLast(E e) {
        /*if (size == data.length) {
            throw new IllegalArgumentException("Array - addLast - data array has full");
        }
        data[size] = e;
        size++;*/
        add(size, e);
    }

    /**
     * 在指定位置插入一个元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Array - add - Required index > 0 && index < data.size");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 所有元素前插入一个元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 获取index索引位置的元素
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

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return res;
    }

    /**
     * 从数组中删除头元素，并返回值
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除尾元素，并返回值
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
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 交换数组中量元素的值
     *
     * @param i
     * @param j
     */
    public void swap(int i, int j) {

        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal.");
        }

        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
