package leetcode.leetcode_766;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ji YongGuang.
 * @date 22:36 2018/11/23.
 * @description
 */
public class LeetCode_766_2 {

    public boolean isToeplitzMatrix2(int[][] matrix) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int key = i - j;
                if (!map.containsKey(key)) {
                    map.put(key, matrix[i][j]);
                } else {
                    if (map.get(key) != matrix[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
