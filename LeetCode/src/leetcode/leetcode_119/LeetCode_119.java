package leetcode.leetcode_119;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ji YongGuang.
 * @date 16:16 2018/11/25.
 * @description 杨辉三角 II
 * <p>
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 */
public class LeetCode_119 {

    /**
     * 输入: 3
     * 输出: [1,3,3,1]
     * <p>
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     */
    public List<Integer> getRow(int rowIndex) {

        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> temp;
        for (int i = 0; i < rowIndex + 1; i++) {// 每层
            temp = new ArrayList<>(i + 1);// 第n层就有n个元素
            lists.add(temp);
            for (int j = 0; j <= i; j++) {// 3 -> 1 2 1
                if (j == 0 || j == i) {// 每行的首尾元素
                    temp.add(1);
                } else {
                    List<Integer> prev = lists.get(i - 1);
                    int leftH = prev.get(j - 1);
                    int rightH = prev.get(j);
                    temp.add(leftH + rightH);
                }
            }
        }
        List<Integer> res = lists.get(rowIndex);
        return res;
    }

    public static void main(String[] args) {
        LeetCode_119 leetCode_119 = new LeetCode_119();
        List<Integer> res = leetCode_119.getRow(3);

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
