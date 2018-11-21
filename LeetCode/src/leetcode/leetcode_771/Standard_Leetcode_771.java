package leetcode.leetcode_771;

/**
 * @author Ji YongGuang.
 * @date 9:58 2018/11/21.
 * @description
 */
public class Standard_Leetcode_771 {

    public int numJewelsInStones(String J, String S) {
        // check for bad inputs
        if (J.length() == 0 || J.length() > 50 || S.length() == 0 || S.length() > 50) {
            return 0;
        }
        // character hash
        int[] chars = new int[58];
        for (char c : J.toCharArray()) {
            // the int value of all appeared chars in J are 1
            //attention: there are 6 Characters between Z and a
            //So the array chars has to have a length of 58
            chars[c - 'A']++;
        }

        // to count jewels number
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            // if the character in J appeared in S
            if (chars[S.charAt(i) - 'A'] > 0) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Long startTime = System.nanoTime();

        Standard_Leetcode_771 standard_leetcode_771 = new Standard_Leetcode_771();
        standard_leetcode_771.numJewelsInStones("aA", "aAAbbbb");

        Long endTime = System.nanoTime();
        // 232014
        System.out.println((endTime - startTime));
    }
}
