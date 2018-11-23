package leetcode.leetcode_905;

/**
 * @author Ji YongGuang.
 * @date 10:05 2018/11/23.
 * @description 按奇偶排序数组
 * <p>
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * <p>
 * 用时:11ms
 */
public class LeetCode_905 {

    /**
     * 提示：
     * <p>
     * 1 <= A.length <= 5000
     * 0 <= A[i] <= 5000
     * 思路:
     * 迭代数组每个元素，找出每个对2取余为0的元素。
     */
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }

        int evenPoint = 0;
        int unEvenPoint = A.length - 1;
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                res[evenPoint++] = A[i];
            } else {
                res[unEvenPoint--] = A[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_905 leetCode_905 = new LeetCode_905();
        int[] target = new int[]{2, 4, 3, 1};
        int[] res = leetCode_905.sortArrayByParity(target);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
