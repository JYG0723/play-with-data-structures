package leetcode.leetcode_167;

/**
 * @author Ji YongGuang.
 * @date 16:20 2018/11/26.
 * @description 两数之和 II - 输入有序数组
 * <p>
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 */
public class LeetCode_167_2 {

    /**
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     * <p>
     * 升序排列 的有序数组
     */
    public int[] twoSum(int[] numbers, int target) {

        int front = 0;
        int tail = numbers.length - 1;

        while (front < tail) {

            if (numbers[front] + numbers[tail] > target) {
                tail--;
            } else if (numbers[front] + numbers[tail] < target) {
                front++;
            } else {
                return new int[]{front + 1, tail + 1};
            }
        }

        return numbers;
    }
}
