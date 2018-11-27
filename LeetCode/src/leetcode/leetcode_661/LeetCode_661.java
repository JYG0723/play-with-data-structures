package leetcode.leetcode_661;

/**
 * @author Ji YongGuang.
 * @date 14:16 2018/11/26.
 * @description 图片平滑器 - 错误
 * <p>
 * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
 * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 */
public class LeetCode_661 {

    /**
     * 输入:
     * [[1,1,1],
     * [1,0,1],
     * [1,1,1]]
     * 输出:
     * [[0, 0, 0],
     * [0, 0, 0],
     * [0, 0, 0]]
     * 解释:
     * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
     * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
     * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
     * <p>
     * 给定矩阵中的整数范围为 [0, 255]。
     * 矩阵的长和宽的范围均为 [1, 150]。
     */
    public int[][] imageSmoother(int[][] M) {

        int len = M.length;
        int sonLen = M[0].length;

        if (sonLen == 1) {
            return M;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < sonLen; j++) {// 二维子元素
                if (((i == 0 || i == len - 1) && (j == 0 || j == sonLen - 1))) {// 四角
                    if (i == 0 && j == 0) {
                        M[i][j] = (M[i][j] + M[i][j + 1] + M[i + 1][j] + M[i + 1][j + 1]) / 4;
                    }
                    if (i == 0 && j == sonLen - 1) {
                        M[i][j] = (M[i][j] + M[i][j - 1] + M[i + 1][j] + M[i + 1][j - 1]) / 4;
                    }
                    if (i == len - 1 && j == 0) {
                        M[i][j] = (M[i][j] + M[i][j + 1] + M[i - 1][j] + M[i - 1][j + 1]) / 4;
                    }
                    if (i == len - 1 && j == sonLen - 1) {
                        M[i][j] = (M[i][j] + M[i][j - 1] + M[i - 1][j] + M[i - 1][j - 1]) / 4;
                    }
                }
                if (i == 0 && j > 0 && j < sonLen - 1) {// 第一横行除头尾节点
                    M[i][j] =
                            (M[i][j] + M[i][j - 1] + M[i][j + 1] + M[i + 1][j] + M[i + 1][j - 1] + M[i + 1][j + 1]) / 6;
                }
                if (i == len - 1 && j > 0 && j < sonLen - 1) {// 第N横行除头尾节点
                    M[i][j] =
                            (M[i][j] + M[i][j - 1] + M[i][j + 1] + M[i - 1][j] + M[i - 1][j - 1] + M[i - 1][j + 1]) / 6;
                }
                if (j == 0 && i > 0 && i < len - 1) {// 第1列除头尾节点
                    M[i][j] =
                            (M[i][j] + M[i - 1][j] + M[i + 1][j] + M[i][j + 1] + M[i - 1][j + 1] + M[i + 1][j + 1]) / 6;
                }
                if (j == sonLen - 1 && i > 0 && i < len - 1) {// 第N列除头尾节点
                    M[i][j] =
                            (M[i][j] + M[i - 1][j] + M[i + 1][j] + M[i][j - 1] + M[i - 1][j - 1] + M[i + 1][j - 1]) / 6;
                }

                if (i > 0 && i < len - 1 && j > 0 && j < sonLen - 1) {// 其余元素
                    M[i][j] =
                            (M[i][j] + M[i][j - 1] + M[i][j + 1] + M[i][j - 1] + M[i - 1][j - 1] + M[i + 1][j - 1] + M[i][j + 1] + M[i + 1][j + 1] + M[i - 1][j + 1]) / 9;
                }
            }
        }

        return M;
    }

    public static void main(String[] args) {
        LeetCode_661 leetCode_661 = new LeetCode_661();
        int[][] testArr = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] res = leetCode_661.imageSmoother(testArr);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < res.length; i++) {
            stringBuilder.append("[");
            for (int j = 0; j < res[0].length; j++) {
                stringBuilder.append(res[i][j]);
                if (j != res[0].length - 1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("]");
            if (i != res.length - 1) {
                stringBuilder.append(",");
                stringBuilder.append("\n");
            }
        }
        stringBuilder.append("]");

        System.out.println(stringBuilder.toString());
    }
}
