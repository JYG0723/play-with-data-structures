/**
 * @author Ji YongGuang.
 * @date 21:20 2018/4/25.
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BinarySerachTree<E> binarySerachTree;

    public BSTSet() {
        binarySerachTree = new BinarySerachTree<>();
    }

    @Override
    public void add(E e) {
        binarySerachTree.add(e);
    }

    @Override
    public void remove(E e) {
        binarySerachTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return binarySerachTree.contains(e);
    }

    @Override
    public boolean isEmpty() {
        return binarySerachTree.isEmpty();
    }

    @Override
    public int getSize() {
        return binarySerachTree.getSize();
    }
}
