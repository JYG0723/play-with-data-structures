import java.util.Arrays;

/**
 * @author Ji YongGuang.
 * @date 14:50 2018/5/2.
 * 冒泡排序
 */
public class BubbleSort {

    public static void bubbleSorrt(int[] arr, int n) {

        int flag;
        for (int j = arr.length - 1; j > 0; j--) {
            flag = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = 1;
                }
            }
            if (flag == 0) {
                return;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6};
        bubbleSorrt(arr, 10);
        System.out.println(Arrays.toString(arr));
    }
}
