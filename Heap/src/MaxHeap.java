/**
 * @author Ji YongGuang.
 * @date 11:33 2018/4/27.
 * 基于Array实现的MaxHeap
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> array;

    public MaxHeap() {
        array = new Array<>();
    }

    public MaxHeap(int capacity) {
        array = new Array<>(capacity);
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 返回二叉堆的数组实现中，一个索引所表示的节点的父亲节点的索引
     *
     * @return
     */
    public int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) >> 1;
    }

    /**
     * 返回二叉堆的数组实现中，一个索引所表示的节点的左孩子节点的索引
     *
     * @param index
     * @return
     */
    public int leftChild(int index) {
        return (index << 1) + 1;
    }

    /**
     * 返回二叉堆的数组实现中，一个索引所表示的节点的右孩子节点的索引
     *
     * @param index
     * @return
     */
    public int rightChild(int index) {
        return (index << 1) + 2;
    }

    /**
     * 向二叉堆中插入一个元素e
     *
     * @param e
     */
    public void add(E e) {
        array.addLast(e);
        // 把新茶入的元素排到他正确的位置
        siftUp(array.getSize() - 1);
    }

    /**
     * 元素上浮
     */
    private void siftUp(int index) {

        while (index > 0 && array.get(
                parent(index)).compareTo(array.get(index)) < 0) {
            // 换值 但是index任指向原来的位置
            array.swap(parent(index), index);
            // index 指向也上移
            index = parent(index);
        }
    }

    /**
     * 返回堆中最大元素
     */
    private E findMax() {
        if (array.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return array.get(0);
    }

    /**
     * 取出堆中最大元素
     *
     * @return
     */
    public E extractMax() {

        E max = findMax();

        array.swap(0, array.getSize() - 1);
        array.removeLast();
        siftDown(0);

        return max;
    }

    /**
     * 元素下浮
     */
    public void siftDown(int index) {

        // 有左孩子
        while (leftChild(index) < array.getSize()) {

            int i = leftChild(index);

            // 右孩子也有且元素值大于左孩子
            if (rightChild(index) < array.getSize() && array.get(i + 1).compareTo(array.get(i)) > 0) {
                i = rightChild(index);
            }

            // 有序
            if (array.get(index).compareTo(array.get(i)) >= 0) {
                break;
            }
            array.swap(index, i);
            index = i; // 这步别忘
        }
    }


}
