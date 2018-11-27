package leetcode.leetcode_1;

/**
 * @author Ji YongGuang.
 * @date 15:56 2018/11/26.
 * @description 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class LeetCode_1 {

    /**
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public int[] twoSum(int[] nums, int target) {

        int len = nums.length;
        int index = 0;

        int[] res = new int[2];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LeetCode_1 leetCode_1 = new LeetCode_1();
        int[] testArr = new int[]{2, 7, 11, 15};
        int[] res = leetCode_1.twoSum(testArr, 9);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(res[0]);
        stringBuilder.append(", ");
        stringBuilder.append(res[1]);
        stringBuilder.append("]");

        System.out.println(stringBuilder.toString());
    }
}
