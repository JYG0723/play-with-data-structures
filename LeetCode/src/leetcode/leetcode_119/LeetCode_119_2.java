package leetcode.leetcode_119;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ji YongGuang.
 * @date 17:10 2018/11/25.
 * @description
 */
public class LeetCode_119_2 {

    /**
     * 递归
     * <p>
     * 输入: 3
     * 输出: [1,3,3,1]
     * <p>
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     */
    public List<Integer> getRow2(int rowIndex) {// 返回每行的结果

        if (rowIndex < 0) {
            return null;
        }

        List<Integer> res = new ArrayList<>();
        List<Integer> prev = getRow2(rowIndex - 1);
        for (int i = 0; i < rowIndex + 1; i++) { // 3 -> [1,3,3,1]
            if (i == 0 || i == rowIndex) {
                res.add(1);
            } else {
                int leftH = prev.get(i - 1);
                int rightH = prev.get(i);
                res.add(leftH + rightH);
            }
        }

        return res;
    }
}
