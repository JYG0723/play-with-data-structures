import java.util.Arrays;

/**
 * @author Ji YongGuang.
 * @date 18:54 2018/5/2.
 * 归并排序
 */
public class MergeSort {

    private static void merge(int[] arr, int[] arrA, int l, int rEnd) {
        int center;

        if (l < rEnd) { // l = rEnd 退出
            center = (l + rEnd) / 2;
            merge(arr, arrA, l, center);
            merge(arr, arrA, center + 1, rEnd);
            merge(arr, arrA, 1, center + 1, rEnd);
        }
    }

    /**
     * @param arr  待排数组
     * @param arrA 有序数组
     * @param l    第一个待合并数组的头索引
     * @param r    第二个待合并数组的头索引
     * @param rEnd 第一个待合并数组的尾索引
     */
    private static void merge(int[] arr, int[] arrA, int l, int r, int rEnd) {
        int index = l;// 有序数组存放元素的起始位置
        int lEnd = r - 1;// 第一个待合并数组的尾索引
        int arrAlength = rEnd - l + 1;// 有序数组总容量

        while (l <= lEnd && r <= rEnd) {
            if (arr[l] <= arr[r]) {
                arrA[index++] = arr[l++];
            } else {
                arrA[index++] = arr[r++];
            }
        }

        //TODO l > lEnd || r > rEnd
        while (l <= lEnd) {
            arrA[index++] = arr[l++];
        }

        //TODO l > lEnd || r > rEnd
        while (r <= rEnd) {
            arrA[index++] = arr[r++];
        }

        for (int i = 0; i < arrAlength; i++, rEnd--) {
            arr[rEnd] = arrA[rEnd];
        }
    }

    public static void mergeSort(int[] arr, int n) {
        merge(arr, new int[n], 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6};
        mergeSort(arr, 8);
        System.out.println(Arrays.toString(arr));
    }
}
