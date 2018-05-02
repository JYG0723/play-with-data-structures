import java.util.ArrayList;

/**
 * @author Ji YongGuang.
 * @date 7:51 2018/4/26.
 * 用来测Set集合的不同实现方式的性能差异
 */
public class Main {

    public static double testSet(Set<String> set, String fileName) {

        Long startTime = System.nanoTime();

        // 统计词汇/
        System.out.println(fileName);
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("E:\\IntelliJ IDEA " +
                "2017.1Projects\\PlayWithDataStructures\\Set\\" + fileName, words1)) {
            System.out.println("Total words: " + words1.size());
            for (String word : words1) {
                set.add(word);
            }
            System.out.println("Total different words: " + set.getSize());
        }

        Long endTime = System.nanoTime();

        // 精确到浮点
        return (endTime - startTime) / Math.pow(10, 9) / 1.0;
    }

    public static void main(String[] args) {
        String fileName = "pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double bstTime = testSet(bstSet, fileName);
        System.out.printf("BSTSet Spend Time: %f s\n", bstTime);

        System.out.println();

        LinkedListSert<String> linkedListSert = new LinkedListSert<>();
        double linkedTime = testSet(linkedListSert, fileName);
        System.out.printf("LinkedListSet Spend Time: %f s\n", linkedTime);
    }
}
