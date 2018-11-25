package leetcode.leetcode_485;

/**
 * @author Ji YongGuang.
 * @date 20:08 2018/11/25.
 * @description 最大连续1的个数
 * <p>
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 */
public class LeetCode_485 {

    /**
     * 输入: [1,1,0,1,1,1]
     * 输出: 3
     * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
     * <p>
     * 说明：
     * 输入的数组只包含 0 和1。
     */
    public int findMaxConsecutiveOnes(int[] nums) {

        int len = nums.length;

        int soldier = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {// 遇到1
                int count = 0;
                for (int j = i; j < len && nums[j] == 1; j++) {
                    count++;
                }
                if (count > soldier) {
                    soldier = count;
                }
            }
        }

        return soldier;
    }

    public static void main(String[] args) {
        LeetCode_485 leetCode_485 = new LeetCode_485();
        int[] testArr = new int[]{1, 1, 1, 0, 1, 1, 1};
        System.out.println(leetCode_485.findMaxConsecutiveOnes(testArr));
    }
}
