package leetcode.leetcode_121;

/**
 * @author Ji YongGuang.
 * @date 21:40 2018/11/25.
 * @description 买卖股票的最佳时机
 */
public class LeetCode_121_2 {


    public int maxProfit(int[] prices) {

        int len = prices.length;
        int min = prices[0];
        int maxDiff = prices[1] - min;

        for (int i = 2; i < len; i++) {
            // 实验每个元素是否可以当最小元素
            if (prices[i - 1] < min) {// 找最小元素
                min = prices[i - 1];
            }

            // 当前元素的最大数值差
            int currDiff = prices[i] - min;
            if (currDiff > maxDiff) {
                maxDiff = currDiff;
            }
        }

        return maxDiff > 0 ? maxDiff : 0;
    }

    /**
     * 可以先预选好结果，
     *      比如首先prices[0]是该数组中最小元素
     *      比如prices[1]-prices[0]是最大数值差
     *  然后再迭代后续元素，替换掉该最小元素及最大数值差
     */
    public static void main(String[] args) {
        LeetCode_121_2 leetCode_121 = new LeetCode_121_2();
        int[] testArr = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(leetCode_121.maxProfit(testArr));
    }
}
