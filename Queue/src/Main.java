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

        // 耗时在没删除一个元素都要移动一遍整个数组
        // 十万8.2秒
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        // O(n2)
        double arrayTime = testQueue(arrayQueue, count);
        System.out.printf("ArrayQueue Time: %f\n", arrayTime);

        // 一千万4.3秒  一百万0.12 十万0.02
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        // O(n)
        double loopTime = testQueue(loopQueue, count);
        System.out.printf("LoopQueue Time: %f\n", loopTime);

        // 一千万4.8秒  一百万0.15 十万0.015
        // 与LoopQueue区别在于引用的变换耗时
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        // O(n)
        double linkedListTime = testQueue(linkedListQueue, count);
        System.out.printf("LinkedListQueue Time: %f\n", linkedListTime);
    }
}
