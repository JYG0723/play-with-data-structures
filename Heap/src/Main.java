import java.util.Random;

/**
 * @author Ji YongGuang.
 * @date 14:04 2018/4/27.
 */
public class Main {

    public static void main(String[] args) {

        int count = (int) Math.pow(10, 6);

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] res = new int[count];
        for (int i = 0; i < maxHeap.getSize(); i++) {
            res[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < res.length; i++) {
            if (res[i - 1] < res[i]) {
                throw new IllegalArgumentException("errors!");
            }
        }
        System.out.println("Yes!");
    }
}
