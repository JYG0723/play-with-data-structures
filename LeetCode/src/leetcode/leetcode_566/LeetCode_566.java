package leetcode.leetcode_566;

/**
 * @author Ji YongGuang.
 * @date 18:04 2018/11/23.
 * @description 重塑矩阵
 * <p>
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 */
public class LeetCode_566 {

    /**
     * 输入:
     * nums =
     * [[1,2],
     * [3,4]]
     * r = 1, c = 4
     * 输出:
     * [[1,2,3,4]]
     * 解释:
     * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int len = nums.length;
        int sonLen = nums[0].length;

        // 不合理
        if (len * sonLen != r * c) {
            return nums;
        }

        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                /*
                   分析：
                    1. 元素填充 要保证行遍历顺序和原二位数组一致，必须锁定当前填充节点在原数组的位置
                    2. 关于位置的计算，因为2个数组保证了元素的完全一致，只是结构重构，
                    3. 所以总数一致的话，只可能是组成数组的因数不同。或因数相同横纵坐标相反
                */
                /*
                    1. 首先确定新数组要填充的元素是行遍历的第多少个元素
                    2. 然后除以重构前数组的x轴因数r，商即是新数组x轴的数值，余数即是y轴数值
                 */
                // 原数组x轴位置
                int x = (i * c + j) / sonLen;
                // 原数组y轴位置
                int y = (i * c + j) % sonLen;
                res[i][j] = nums[x][y];
            }
        }
        return res;
    }

    /**
     * 收货:
     * 1. 元素在二维数组行遍历后中的位置，可以通过元素所在的 [x,y轴乘机+y(偏移量)] 来得到
     * 2. 数组的位置处理都是一致的，不需要过多考虑下标是否为0
     *
     * @param args
     */
    public static void main(String[] args) {
        LeetCode_566 leetCode_566 = new LeetCode_566();
        int[][] test = new int[][]{{1, 2, 3}, {3, 4, 5}};
        int[][] res = leetCode_566.matrixReshape(test, 3, 2);

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
