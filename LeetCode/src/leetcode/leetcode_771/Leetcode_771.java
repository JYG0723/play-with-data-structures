package leetcode.leetcode_771;

/**
 * @author Ji YongGuang.
 * @date 9:21 2018/11/21.
 * @description 宝石与石头
 */
public class Leetcode_771 {

    /**
     * 输入: J = "aA", S = "aAAbbbb"
     * 输出: 3
     *
     * 输入: J = "z", S = "ZZ"
     * 输出: 0
     *
     * @param J 石头
     * @param S 宝石
     *
     *  按字符切分J，然后将J的切分结果存到数组或集合中，然后根据容器中每个元素去拿到S中统计个数。再计算总和即可。
     */
    public static int numJewelsInStones(String J, String S) {

        char[] chars = J.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int i1 = 0; i1 < S.length(); i1++) {
                if (chars[i] == S.charAt(i1)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Long startTime = System.nanoTime();
        System.out.println(numJewelsInStones("z", "ZZ"));
        Long endTime = System.nanoTime();
        // 692625
        System.out.println((endTime - startTime));
    }
}
