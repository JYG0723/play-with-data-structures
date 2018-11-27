package leetcode.leetcode_448;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ji YongGuang.
 * @date 10:00 2018/11/27.
 * @description
 */
public class LeetCode_448_2 {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();
        boolean[] flags = new boolean[nums.length + 1];

        for (int num : nums) {
            flags[num] = true;
        }

        int length = flags.length;
        for (int i = 1; i < length; i++) {
            if (!flags[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
