import java.util.ArrayList;

/**
 * @author Ji YongGuang.
 * @date 21:20 2018/4/25.
 * 基于二分搜索树实现的Set集合
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BinarySerachTree<E> binarySerachTree;

    public BSTSet() {
        binarySerachTree = new BinarySerachTree<>();
    }

    /**
     * 如果集合中已经存在该元素不做处理
     *
     * @param e
     */
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

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("E:\\IntelliJ IDEA " +
                "2017.1Projects\\PlayWithDataStructures\\Set\\pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for (String word : words1) {
                set1.add(word);
            }
            System.out.println("Total different words: " + set1.getSize());
        }


        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("E:\\IntelliJ IDEA " +
                "2017.1Projects\\PlayWithDataStructures\\Set\\a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            BSTSet<String> set2 = new BSTSet<>();
            for (String word : words2) {
                set2.add(word);
            }
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}
