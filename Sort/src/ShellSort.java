import java.util.Arrays;

/**
 * @author Ji YongGuang.
 * @date 15:52 2018/5/2.
 * 希尔排序
 */
public class ShellSort {

    public static void shellSort(int[] arr, int n) {

        int i, j, k;
        int temp;

        for (k = arr.length / 2; k > 0; k /= 2) {// 希尔增量序列
            for (i = k; i < arr.length; i++) {// 插入排序
                temp = arr[i];
                for (j = i; j >= k && arr[j - k] > temp; j-=k) {
                    arr[j] = arr[j - k];
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6};
        shellSort(arr, 10);
        System.out.println(Arrays.toString(arr));
    }
}
