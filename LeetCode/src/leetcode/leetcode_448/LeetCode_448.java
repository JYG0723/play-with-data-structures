package leetcode.leetcode_448;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ji YongGuang.
 * @date 17:21 2018/11/26.
 * @description 找到所有数组中消失的数字
 * <p>
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 */
public class LeetCode_448 {

    /**
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * 输出:
     * [5,6]
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int len = nums.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            // 1 <= nums[i] <= n
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {// 说明i对应的数值 - 数组中没有
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode_448 leetCode_448 = new LeetCode_448();
        int[] testArr = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = leetCode_448.findDisappearedNumbers(testArr);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < res.size(); i++) {
            stringBuilder.append(res.get(i));
            if (i != res.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");

        System.out.println(stringBuilder.toString());
    }
}
