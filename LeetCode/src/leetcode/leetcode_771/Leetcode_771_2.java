package leetcode.leetcode_771;

/**
 * @author Ji YongGuang.
 * @date 10:07 2018/11/21.
 * @description
 */
public class Leetcode_771_2 {

    public static int numJewelsInStones(String J, String S) {

        if (J.length() < 0 || J.length() > 50 || S.length() < 0 || S.length() > 50) {
            return 0;
        }

        // 从A开始计数的 每个字符的index
        int[] chars = new int[58];
        for (char c :
                J.toCharArray()) {
            // [0,0,1,1,0,0 ...]
            chars[(c - 'A')]++;
        }

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (chars[(S.charAt(i) - 'A')] > 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }
}
