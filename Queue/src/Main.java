import java.util.Random;

/**
 * @author Ji YongGuang.
 * @date 7:37 2018/4/19.
 */
public class Main {

    /**
     * 测试运行 parCount 个入队出队操作，ArrayQueue和LoopQueue的性能差异
     *
     * @param queue
     * @param parCount
     * @return
     */
    private static double testQueue(Queue<Integer> queue, int parCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < parCount; i++) {
            queue.enQueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < parCount; i++) {
            queue.deQueue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int count = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayTime = testQueue(arrayQueue, count);
        System.out.printf("ArrayQueue Time: %f\n", arrayTime);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double loopTime = testQueue(loopQueue, count);
        System.out.printf("LoopQueue Time: %f\n", loopTime);
    }
}
