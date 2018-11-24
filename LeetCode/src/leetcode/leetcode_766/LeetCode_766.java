package leetcode.leetcode_766;

/**
 * @author Ji YongGuang.
 * @date 22:02 2018/11/23.
 * @description 托普利茨矩阵
 * <p>
 * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 */
public class LeetCode_766 {

    /**
     * 输入:
     * matrix = [
     * [1,2,3,4],
     * [5,1,2,3],
     * [9,5,1,2]
     * ]
     * 输出: True
     * 解释:
     * 在上述矩阵中, 其对角线为:
     * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
     * 各条对角线上的所有元素均相同, 因此答案是True。
     */
    public boolean isToeplitzMatrix(int[][] matrix) {

        int len = matrix.length;
        int sonLen = matrix[0].length;

        // 此题只需要考虑，什么情况下其不满足`托普利茨矩阵`即可。
        for (int i = 0; i < len - 1; i++) {// 最后一行不需要考虑
            for (int j = 0; j < sonLen - 1; j++) {// 最后一列元素不需要考虑
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 二维数组的每个元素的x,y轴的数值，可能在题目的语义中都有特别的数学关系。需要额外关注。
     *
     * @param args
     */
    public static void main(String[] args) {

        LeetCode_766 leetCode_766 = new LeetCode_766();
        int[][] testArray = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        int[][] testArray2 = new int[][]{{1, 2}, {2, 2}};
        boolean res = leetCode_766.isToeplitzMatrix(testArray);
        boolean res2 = leetCode_766.isToeplitzMatrix(testArray2);

        System.out.println(res);// true
        System.out.println(res2);// false
    }
}
