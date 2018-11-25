package leetcode.leetcode_27;

/**
 * @author Ji YongGuang.
 * @date 19:59 2018/11/25.
 * @description
 */
public class LeetCode_27_2 {

    public int removeElement(int[] nums, int val) {

        int len = nums.length;
        int correct = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {// 筛选出正确元素
                nums[correct] = nums[i];
                correct++;
            }
        }

        return correct;
    }

    public static void main(String[] args) {
        LeetCode_27_2 leetCode_27 = new LeetCode_27_2();
        //0, 1, 2, 2, 3, 0, 4, 2
        int[] testArray = new int[]{2, 2, 2, 2, 3, 0, 4, 1};
        int res = leetCode_27.removeElement(testArray, 2);

        System.out.printf("数组有效元素长度: %d", res);
        System.out.printf("\n");

        System.out.printf("[");
        for (int i = 0; i < res; i++) {
            if (i != testArray.length - 1)
                System.out.printf("%d,", testArray[i]);
            else
                System.out.printf("%d", testArray[i]);
        }
        System.out.printf("]");

        System.out.printf("\n");

        System.out.printf("[");
        for (int i = 0; i < testArray.length; i++) {
            if (i != testArray.length - 1)
                System.out.printf("%d,", testArray[i]);
            else
                System.out.printf("%d", testArray[i]);
        }
        System.out.printf("]");
    }
}
