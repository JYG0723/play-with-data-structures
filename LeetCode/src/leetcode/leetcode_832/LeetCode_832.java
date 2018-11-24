package leetcode.leetcode_832;

/**
 * @author Ji YongGuang.
 * @date 13:44 2018/11/23.
 * @description 数组拆分
 * <p>
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 */
public class LeetCode_832 {

    /**
     * 输入: [[1,1,0],[1,0,1],[0,0,0]]
     * 输出: [[1,0,0],[0,1,0],[1,1,1]]
     * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
     * <p>
     * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
     * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     * <p>
     * 1 <= A.length = A[0].length <= 20
     * 0 <= A[i][j] <= 1
     */
    public int[][] flipAndInvertImage(int[][] A) {

        int len = A.length;
        int sonLen = len;

        // 水平翻转
        for (int i = 0; i < len; i++) {
            int index = sonLen - 1;// 最后一个元素的index
            for (int j = 0; j < sonLen; j++) {
                if (j == index) {// len - 奇
                    A[i][j] = (A[i][j] & 1) == 1 ? 0 : 1;
                    break;
                }
                if (j > index) {
                    break;
                }
                // 反转图片
                int temp = (A[i][j] & 1) == 1 ? 0 : 1;
                A[i][j] = (A[i][index] & 1) == 1 ? 0 : 1;
                A[i][index] = temp;
                index--;
            }
        }
        return A;
    }

    public static void main(String[] args) {

        LeetCode_832 leetCode_832 = new LeetCode_832();
        int[][] ints = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] res = leetCode_832.flipAndInvertImage(ints);

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
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }
}