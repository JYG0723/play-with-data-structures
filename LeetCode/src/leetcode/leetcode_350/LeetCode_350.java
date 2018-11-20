package leetcode.leetcode_350;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Ji YongGuang.
 * @date 8:15 2018/4/27.
 * 两个数组的交集 II
 */
public class LeetCode_350 {

    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {

            Map<Integer, Integer> nums1Map = new TreeMap<>();

            for (int i = 0; i < nums1.length; i++) {
                if (nums1Map.containsKey(nums1[i])) {
                    nums1Map.put(nums1[i], nums1Map.get(nums1[i]) + 1);
                } else {
                    nums1Map.put(nums1[i], 1);
                }
            }

            ArrayList<Integer> eArrayList = new ArrayList<>();
            for (int i : nums2) {
                if (nums1Map.containsKey(i)) {
                    eArrayList.add(i);
                    nums1Map.put(i, nums1Map.get(i) - 1);
                    if (nums1Map.get(i) == 0) {
                        nums1Map.remove(i);
                    }
                }
            }

            int[] res = new int[eArrayList.size()];
            for (int i = 0; i < eArrayList.size(); i++) {
                res[i] = eArrayList.get(i);
            }
            return res;
        }
    }
}