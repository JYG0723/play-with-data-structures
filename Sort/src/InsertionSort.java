import java.util.Arrays;

/**
 * @author Ji YongGuang.
 * @date 15:28 2018/5/2.
 * 插入排序
 */
public class InsertionSort {

    public static void insertSort(int[] arr, int n) {

        int temp, i, j;
        for (i = 1; i < arr.length; i++) {// 摸第二张牌
            temp = arr[i];
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {// 如果第一张牌比第二张牌大
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6};
        insertSort(arr,10);
        System.out.println(Arrays.toString(arr));
    }
}
