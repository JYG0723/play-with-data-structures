package leetcode.leetcode_1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ji YongGuang.
 * @date 16:12 2018/11/26.
 * @description
 */
public class LeetCode_1_2 {

    public int[] twoSum(int[] nums, int target) {

        int len = nums.length;
        // Key - nums[i], Value - i
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return nums;
    }
}
