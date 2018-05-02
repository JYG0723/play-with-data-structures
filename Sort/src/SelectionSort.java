import java.util.Arrays;

/**
 * @author Ji YongGuang.
 * @date 17:06 2018/5/2.
 * 选择排序
 */
public class SelectionSort {

    public static void selectSort(int[] arr, int n) {
        int index, value;
        // TODO 记录最小元素和位置
        for (int i = 0; i < arr.length; i++) {
            index = i;
            value = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < value) {// 寻找最小元素
                    index = j;
                    value = arr[j];
                }
            }
            // TODO 交换元素值
            arr[index] = arr[i];
            arr[i] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6};
        selectSort(arr, 10);
        System.out.println(Arrays.toString(arr));
    }
}
