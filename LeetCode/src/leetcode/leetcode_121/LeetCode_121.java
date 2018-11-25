package leetcode.leetcode_121;

/**
 * @author Ji YongGuang.
 * @date 21:40 2018/11/25.
 * @description 买卖股票的最佳时机
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 */
public class LeetCode_121 {

    /**
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     */
    public int maxProfit(int[] prices) {//7,3,8,2,1,4

        int len = prices.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (prices[j] > prices[i]) {
                    res = Math.max(res, prices[j] - prices[i]);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LeetCode_121 leetCode_121 = new LeetCode_121();
        int[] testArr = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(leetCode_121.maxProfit(testArr));
    }
}
