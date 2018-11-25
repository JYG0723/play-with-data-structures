package leetcode.leetcode_27;

/**
 * @author Ji YongGuang.
 * @date 17:40 2018/11/25.
 * @description 移除元素
 * <p>
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class LeetCode_27 {

    /**
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * 注意这五个元素可为任意顺序。
     */
    public int removeElement(int[] nums, int val) {

        int len = nums.length;
        int defCount = 0;
        for (int i = 0; i < len - defCount; i++) {
            if (nums[i] == val) {
                defCount++;

                // 移动整个后续数组向前填充，保证了相对距离
                for (int j = i + 1; j < len; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
            }
        }
        return len - defCount;
    }

    /**
     * 上面自己的做法想复杂了，直接连剩余元素的相对位置都保证了。
     */
    public static void main(String[] args) {
        LeetCode_27 leetCode_27 = new LeetCode_27();
        //0, 1, 2, 2, 3, 0, 4, 2
        int[] testArray = new int[]{2, 2, 2, 2, 3, 0, 4, 1};
        int res = leetCode_27.removeElement(testArray, 2);

        System.out.printf("数组有效元素长度: %d", res);
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
