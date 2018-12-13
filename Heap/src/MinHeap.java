/**
 * @author Ji YongGuang.
 * @date 10:34 2018/12/13.
 * @description 最小堆
 */
public class MinHeap<E extends Comparable<E>> {

    private Array<E> array;

    public MinHeap(int capacity) {
        array = new Array<>(capacity);
    }

    public MinHeap() {
    }

    public MinHeap(Array<E> array) {
        // 从最后一个叶子节点的父节点开始到根节点依次做下沉操作
        for (int i = array.getSize() / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    // 下沉数组下标为index的元素
    private void siftDown(int index) {
        // 左孩子存在
        while (leftChild(index) < array.getSize()) {
            int i = leftChild(index);
            // 右孩子大于当前节点
            if (array.get(rightChild(index)).compareTo(array.get(index)) > 0) {
                i = rightChild(index);
            }
            // 是否有孩子节点大于当前节点
            if (array.get(i).compareTo(array.get(index)) > 0) {
                swap(i, index);
            }
            index = i;// 继续向下下沉
        }
    }

    // 交换数组两坐标的元素值
    private void swap(int i, int j) {
        E temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    // 返回数组下表为index 的父元素的索引
    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return index << 2;
    }

    private int rightChild(int index) {
        return index << 2 + 1;
    }
}
