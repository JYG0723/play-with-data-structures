package leetcode.leetcode_203;

/**
 * @author Ji YongGuang.
 * @date 10:42 2018/4/20.
 */
public class Sum {


    /**
     * 计算数组总和
     *
     * @param arr
     * @return
     */
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * 计算数组从l处到arr[]数组尾元素总和
     *
     * @param arr
     * @param l
     * @return
     */
    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }

        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        int count = sum(arr);

        System.out.println(count);
    }
}
