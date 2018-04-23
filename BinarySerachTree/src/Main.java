import java.util.ArrayList;
import java.util.Random;

/**
 * @author Ji YongGuang.
 * @date 9:15 2018/4/23.
 */
public class Main {

    public static void main(String[] args) {

        /*int[] arr = {5, 3, 6, 8, 4, 2};

        BinarySerachTree<Integer> binarySerachTree = new BinarySerachTree<>();
        for (int e : arr) {
            binarySerachTree.add(e);
        }

        binarySerachTree.preOrder();
        System.out.println();*/

        /*binarySerachTree.inOrder();
        System.out.println();

        binarySerachTree.postOrder();
        System.out.println()

        binarySerachTree.preOrderNonR();
        System.out.println();*/
        ;

        /*binarySerachTree.levelOrder();
        System.out.println();*/

        BinarySerachTree<Integer> binarySerachTree = new BinarySerachTree<>();

        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            binarySerachTree.add(random.nextInt(10000));
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        while (!binarySerachTree.isEmpty()) {
            arrayList.add(binarySerachTree.removeMin());
        }
        System.out.println(arrayList);

        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i - 1) > arrayList.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("remove completed");
    }
}
