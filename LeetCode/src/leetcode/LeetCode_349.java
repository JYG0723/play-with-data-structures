package leetcode;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ji YongGuang.
 * @date 7:46 2018/4/27.
 * 两个数组的交集 I
 */
public class LeetCode_349 {

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {

            Set<Integer> nunm1Set = new TreeSet<>();

            for (int i : nums1) {
                nunm1Set.add(i);
            }

            ArrayList<Integer> eArrayList = new ArrayList<>();
            for (int i : nums2) {
                if (nunm1Set.contains(i)) {
                    eArrayList.add(i);
                    nunm1Set.remove(i);
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
