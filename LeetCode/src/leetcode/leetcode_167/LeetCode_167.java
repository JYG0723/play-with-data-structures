package leetcode.leetcode_167;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ji YongGuang.
 * @date 16:20 2018/11/26.
 * @description 两数之和 II - 输入有序数组
 * <p>
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 */
public class LeetCode_167 {

    /**
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     */
    public int[] twoSum(int[] numbers, int target) {

        int len = numbers.length;
        // Key - nums[i], Value - i
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            } else {
                map.put(numbers[i], i);
            }
        }

        return numbers;
    }
}
