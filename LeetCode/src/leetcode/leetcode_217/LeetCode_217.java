package leetcode.leetcode_217;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ji YongGuang.
 * @date 13:56 2018/11/26.
 * @description 存在重复元素
 * <p>
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class LeetCode_217 {

    public boolean containsDuplicate(int[] nums) {

        int len = nums.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate_(int[] nums) {

        int len = nums.length;
        if (len == 1) {
            return false;
        }
        if (len == 2) {
            return nums[0] == nums[1];
        }

        Arrays.sort(nums);

        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        LeetCode_217 leetCode_217 = new LeetCode_217();
        int[] testArr = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        long startTime = System.nanoTime();
        System.out.println(leetCode_217.containsDuplicate(testArr));
        long endTime = System.nanoTime();

        System.out.println(endTime - startTime);
    }
}
