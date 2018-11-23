package leetcode.leetcode_867;

/**
 * @author Ji YongGuang.
 * @date 12:06 2018/11/23.
 * @description 转置矩阵
 * <p>
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 */
public class LeetCode_867 {

    /**
     * 输入：[[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[1,4,7],[2,5,8],[3,6,9]]
     * <p>
     * 输入：[
     * [1,2,3],
     * [4,5,6]
     * ]
     * 输出：[
     * [1,4],
     * [2,5],
     * [3,6]
     * ]
     */
    public int[][] transpose(int[][] A) {
        int x = A.length;// 2
        int y = A[0].length;// 3

        int[][] res = new int[y][x];
        for (int i = 0; i < x; i++) {// 2
            for (int j = 0; j < y; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_867 leetCode_867 = new LeetCode_867();
        int[][] ints = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int[][] res = leetCode_867.transpose(ints);
        for (int i = 0; i < res.length; i++) {
            for (int i1 = 0; i1 < res[0].length; i1++) {
                System.out.println(res[i][i1]);
            }
        }
    }
}
