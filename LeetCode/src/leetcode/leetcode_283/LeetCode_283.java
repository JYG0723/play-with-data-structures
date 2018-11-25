package leetcode.leetcode_283;

/**
 * @author Ji YongGuang.
 * @date 11:21 2018/11/24.
 * @description 移动零 - 自己想的错误答案
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class LeetCode_283 {

    /**
     * 输入: [0,1,0,3,12] -> [1,0,3,12,0]
     * 输出: [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {

        int len = nums.length;
        int zeroCount = 0;// value为0 的数组元素个数

        for (int i = 0; i < len; i++) {
            if (i + zeroCount >= len || i < 0) {// 不再遍历后续为0的元素 || 全为0的情况
                break;
            }
            if (nums[i] == 0) {
                zeroCount++;
                for (int j = i + 1; j < len; j++) {// 010
                    nums[j - 1] = nums[j];
                    if (nums[j - 1] == 0) {// 001 防止后续填充元素也为0，但遍历的数组下标已经越过该元素
                        // 如果数组中元素全为0，那么i会一直--，
                        i--;
                    }
                }
                nums[len - zeroCount] = 0;
            }
        }
    }

    /**
     * 切记数组在移动的时候，要针对元素来移动，而不是数组的空位
     */
    public static void main(String[] args) {
        LeetCode_283 leetCode_283 = new LeetCode_283();
        int[] testArray = new int[]{0, 0, 0}; // 0 0 1
        leetCode_283.moveZeroes(testArray);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < testArray.length; i++) {
            stringBuilder.append(testArray[i]);
            if (i == testArray.length - 1) {
                break;
            }
            stringBuilder.append(",");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }
}
