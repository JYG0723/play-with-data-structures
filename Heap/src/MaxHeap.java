/**
 * @author Ji YongGuang.
 * @date 11:33 2018/4/27.
 * 基于Array实现的MaxHeap
 */
@SuppressWarnings("JavaDoc")
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> array;

    public MaxHeap() {
        array = new Array<>();
    }

    public MaxHeap(int capacity) {
        array = new Array<>(capacity);
    }

    // heapify 操作
    public MaxHeap(E[] arr) {
        array = new Array(arr);
        // 最后一个非叶子节点的父亲节点开始
        for (int i = parent(array.getSize() - 1); i >= 0
                ; i--) {
            siftDown(i);
        }
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
        return index - 1 >> 1;
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

        // 在一层一层的走 所以是O(logN)
        while (index > 0 && array.get(parent(index)).compareTo(array.get(index)) < 0) {
            // 换值 但是index任指向原来的位置
            array.swap(index, parent(index));
            // index 指针也上移，跟着这个还未被准确定为的节点
            index = parent(index);
        }
    }

    /**
     * 返回堆中最大元素
     */
    public E findMax() {
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

        //todo 堆顶元素出堆 -> 1. 最后一个元素数值替换堆顶元素 2. 删除最后一个元素 3. 新的堆顶元素下沉 4. 返回堆顶元素
        //todo 堆顶元素下沉 -> 循环比较下沉元素如果大于左或右孩子节点

        // 有左孩子
        while (leftChild(index) < array.getSize()) {
            int i = leftChild(index);

            // 右孩子也有且元素值大于左孩子 取数值较大的那个元素进行替换
            if (rightChild(index) < array.getSize() && array.get(i + 1).compareTo(array.get(i)) > 0) {
                i = rightChild(index);
            }

            // 大于孩子节点即位置到了，退出循环不再下沉
            if (array.get(index).compareTo(array.get(i)) >= 0) {
                break;
            }
            // 更换数值继续下沉
            array.swap(index, i);
            index = i; // 这步别忘
        }
    }

    /**
     * 取出堆中最大元素 并且替换成元素e
     */
    public E replace(E e) {

        E max = findMax();
        array.set(0, e);
        siftDown(0);
        return max;
    }
}
