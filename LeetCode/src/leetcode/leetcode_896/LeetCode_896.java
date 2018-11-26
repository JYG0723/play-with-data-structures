package leetcode.leetcode_896;

/**
 * @author Ji YongGuang.
 * @date 13:39 2018/11/26.
 * @description 单调数列
 * <p>
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 */
public class LeetCode_896 {

    public boolean isMonotonic(int[] A) {

        int len = A.length;
        int head = A[0];

        boolean type = true;
        for (int i = 0; i < len; i++) {
            if (A[i] != head) {
                type = A[i] - head > 0;
            }
        }

        for (int i = 1; i < len; i++) {
            if (type) {// 递增
                if (A[i] < A[i - 1]) {
                    return false;
                }
            } else {
                if (A[i] > A[i - 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LeetCode_896 leetCode_896 = new LeetCode_896();
        int[] testArr = new int[]{1,1,1};
        System.out.println(leetCode_896.isMonotonic(testArr));
    }
}
