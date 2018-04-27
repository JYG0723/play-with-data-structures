import java.util.ArrayList;

/**
 * @author Ji YongGuang.
 * @date 23:36 2018/4/26.
 */
public class Main {

    public static double testMap(Map<String, Integer> map, String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);

        ArrayList<String> words = new ArrayList<>();
        // 所有词存入words
        if (FileOperation.readFile("E:\\IntelliJ IDEA " +
                "2017.1Projects\\PlayWithDataStructures\\Map\\" + filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }

            System.out.println("所有不同的单词数量: " + map.getSize());
            System.out.println("pride 单词出现的次数" + map.get("pride"));
            System.out.println("Prejudice 单词出现的次数" + map.get("prejudice"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / Math.pow(10, 9) / 1.0;
    }

    public static void main(String[] args) {

        String filename = "pride-and-prejudice.txt";

        BSTMap<String, Integer> bstMap = new BSTMap<>();
        double bstTime = testMap(bstMap, filename);
        System.out.println("BST Map: " + bstTime + " s");

        System.out.println();

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double linkedTime = testMap(linkedListMap, filename);
        System.out.println("Linked List Map: " + linkedTime + " s");
    }
}
