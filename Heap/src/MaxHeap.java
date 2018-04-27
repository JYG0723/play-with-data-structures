/**
 * @author Ji YongGuang.
 * @date 11:33 2018/4/27.
 * 基于Array实现的MaxHeap
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> array;

    public MaxHeap() {
        array = new Array<>()
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
        return index << 2 + 1;
    }

    /**
     * 返回二叉堆的数组实现中，一个索引所表示的节点的右孩子节点的索引
     *
     * @param index
     * @return
     */
    public int rightChild(int index) {
        return index << 2 + 2;
    }
}
