public class Main {

    public static void main(String[] args) {
        // write your code here
        Array<Integer> array = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);

        array.remove(4);
        System.out.println(array);

        array.removeElement(100);
        System.out.println(array);
    }
}
