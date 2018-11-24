package leetcode.leetcode_169;

import java.util.Arrays;

/**
 * @author Ji YongGuang.
 * @date 23:09 2018/11/23.
 * @description
 */
public class LeetCode_169_2 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
