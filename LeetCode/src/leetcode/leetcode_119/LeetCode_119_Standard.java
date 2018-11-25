package leetcode.leetcode_119;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ji YongGuang.
 * @date 17:11 2018/11/25.
 * @description
 */
public class LeetCode_119_Standard {

    /**
     * 思路：
     *  用一个集合来存储每层的元素
     *  通过元素间索引的关系，不断的更新集合中的元素的数值，最后将该集合返回。
     *     1
     *    1 1
     *   1 2 1
     *  1 3 3 1
     * 1 4 6 4 1
     */
    public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList(rowIndex + 1);

        for (int i = 0; i < rowIndex + 1; i++) {// 控制层数
            res.add(1);
            for (int j = i - 1; j > 0; j--) {// 控制每层元素在集合中数值的更迭
                // 由后向前
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }

        return res;
    }
}
