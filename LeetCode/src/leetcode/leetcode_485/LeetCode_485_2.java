package leetcode.leetcode_485;

/**
 * @author Ji YongGuang.
 * @date 21:24 2018/11/25.
 * @description
 */
public class LeetCode_485_2 {

    public int findMaxConsecutiveOnes(int[] nums) {

        int len = nums.length;

        int nowMax = 0;
        int sinCount = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                sinCount++;
            } else {
                nowMax = Math.max(nowMax, sinCount);
                sinCount = 0;
            }
        }

        // 防止数组倒数几个元素都为1，for循环自然退出，导致遗漏max函数的比较
        nowMax = Math.max(nowMax, sinCount);
        return nowMax;
    }

    /**
     *
     */
    public static void main(String[] args) {
        LeetCode_485_2 leetCode_485_2 = new LeetCode_485_2();
        int[] testArr = new int[]{1, 1, 1, 0, 1, 1, 1};
        System.out.println(leetCode_485_2.findMaxConsecutiveOnes(testArr));
    }
}
