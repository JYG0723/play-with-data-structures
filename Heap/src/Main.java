import java.util.Random;

/**
 * @author Ji YongGuang.
 * @date 14:04 2018/4/27.
 */
public class Main {

    private static double testHeap(Integer[] testData, boolean isHeapify) {

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (int num : testData) {
                maxHeap.add(num);
            }
        }

        int[] res = new int[testData.length];
        for (int i = 0; i < maxHeap.getSize(); i++) {
            res[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < testData.length; i++) {
            if (res[i - 1] < res[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / Math.pow(10, 9);
    }

    public static void main(String[] args) {

        int count = (int) Math.pow(10, 6);

        Random random = new Random();
        Integer[] testData = new Integer[count];
        for (int i = 0; i < count; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + " s");
    }
}
