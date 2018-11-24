package leetcode.leetcode_169;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ji YongGuang.
 * @date 22:39 2018/11/23.
 * @description 求众数，两种实现方式，哨兵和临界值判定
 * <p>
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 */
public class LeetCode_169 {

    /**
     * 输入: [3,2,3]
     * 输出: 3
     * <p>
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     */
    public int majorityElement(int[] nums) {

        /*if (nums.length == 1) {
            return nums[0];
        }*/

        Map<Integer, Integer> map = new HashMap<>();
        int solder = nums[0];
        for (int i = 0; i < nums.length; i++) {// 3
            int count = 0;
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], ++count);
            } else {
                count = map.get(nums[i]);
                count++;
                map.put(nums[i], count);
            }
            // 哨兵永远指向比自己数量多的元素
            if (map.get(nums[i]) > map.get(solder)) {
                solder = nums[i];
            }
            /*// 每次统计数值之后判断是否超过众数值的临界点
            if (count > nums.length / 2) {
                return nums[i];
            }*/
        }

        return solder;
    }

    public static void main(String[] args) {
        LeetCode_169 leetCode_169 = new LeetCode_169();
        int res = leetCode_169.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(res);
    }
}
