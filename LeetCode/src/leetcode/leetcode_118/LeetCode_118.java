package leetcode.leetcode_118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ji YongGuang.
 * @date 16:48 2018/11/23.
 * @description 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class LeetCode_118 {

    /**
     * 输入: 5
     * 输出:
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {// 每行
            List<Integer> list = new ArrayList<>();
            lists.add(list);
            for (int j = i; j >= 0; j--) {// 每个元素
                if (j == i || j == 0) {
                    list.add(1);
                } else {// 1
                    // 头顶的行
                    List prevList = lists.get(i - 1);
                    // 左上
                    int leftH = ((Integer) prevList.get(j - 1)).intValue();
                    // 右上
                    int rightH = ((Integer) prevList.get(j)).intValue();
                    list.add(leftH + rightH);
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        LeetCode_118 leetCode_118 = new LeetCode_118();
        List res = leetCode_118.generate(6);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < res.size(); i++) {
            for (int size = res.size(); size > 0; size--) {
                stringBuilder.append(" ");
            }
            stringBuilder.append("[");
            List sonList = (List<Integer>) res.get(i);
            int size = sonList.size();
            for (int j = 0; j < size; j++) {
                stringBuilder.append(sonList.get(j));
                if (j != size - 1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("]");
            if (i != res.size() - 1) {
                stringBuilder.append(",");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }
}
