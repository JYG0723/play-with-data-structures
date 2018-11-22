import java.util.Random;

/**
 * @author Ji YongGuang.
 * @date 18:33 2018/4/17.
 */
public class Main {

    public static void main(String[] args) {

        int count = 10000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double arratTime = testStack(arrayStack, count);
        System.out.printf("ArrayStack time: %f\n", arratTime);
        // ArrayStack，LinkedListStack 两者时间差异仅仅是发生在ArrayStack底层数组会发生扩容耗时。
        // LinkedListStack 耗时的地方则在new Node时的new操作上，因为要寻找空间，并且开辟空间等。
        // 两者的push和pop操作都是O(1)级别。
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double linkedListTime = testStack(linkedListStack, count);
        System.out.printf("LinkedList time: %f\n", linkedListTime);

    }

    public static double testStack(Stack stack, int count) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

}
