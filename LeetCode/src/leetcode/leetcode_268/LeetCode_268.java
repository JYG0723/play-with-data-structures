package leetcode.leetcode_268;

/**
 * @author Ji YongGuang.
 * @date 22:37 2018/11/25.
 * @description 缺失数字
 * <p>
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
public class LeetCode_268 {

    /**
     * 输入: [3,0,1]
     * 输出: 2
     * <p>
     * 输入: [9,6,4,2,3,5,7,0,1]
     * 输出: 8
     */
    public int missingNumber(int[] nums) {

        int len = nums.length + 1;
        int sum = (0 + nums.length) * len / 2;

        int nowSum = 0;
        for (int i = 0; i < nums.length; i++) {// 序列的和
            nowSum += nums[i];
        }

        return sum - nowSum;
    }

    public static void main(String[] args) {
        LeetCode_268 leetCode_268 = new LeetCode_268();
        int[] testArr = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(leetCode_268.missingNumber(testArr));
    }
}
