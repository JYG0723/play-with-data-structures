package leetcode.leetcode_832;

/**
 * @author Ji YongGuang.
 * @date 15:56 2018/11/23.
 * @description
 */
public class LeetCode_832_2 {

    /**
     * 1. 数组前序后序 数组下标的关系
     * 2. 异或 ^ 可以实现反转功能
     * -> 第一个操作数的的第n位 与 第二个操作数的第n位 相反，那么结果的第n为为1，否则为0
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < (A.length + 1) / 2; j++) {// 需要控制只走一半
                temp = A[i][j];
                A[i][j] = A[i][A.length - 1 - j] ^ 1;
                A[i][A.length - 1 - j] = temp ^ 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        LeetCode_832_2 leetCode_832 = new LeetCode_832_2();
        int[][] ints = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
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
