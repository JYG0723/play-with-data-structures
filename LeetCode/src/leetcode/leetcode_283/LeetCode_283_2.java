package leetcode.leetcode_283;

/**
 * @author Ji YongGuang.
 * @date 16:00 2018/11/25.
 * @description 标答
 */
public class LeetCode_283_2 {

    /**
     * 把数组首元素默认为0，然后数组的后续元素去替换该0，该0会随着数组下标的递增而被移到最后
     */
    public void moveZeroes(int[] nums) {// 0 1 0 3 12

        int len = nums.length;
        int zeroIndex = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[zeroIndex];
                nums[zeroIndex] = temp;
                zeroIndex++;
            }
        }
    }
}
