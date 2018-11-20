package leetcode.leetcode_804;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ji YongGuang.
 * @date 13:24 2018/4/26.
 * 唯一摩尔斯密码词
 */
public class LeetCode_804 {

    class Solution {
        public int uniqueMorseRepresentations(String[] words) {

            String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", "" +
                    ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-" +
                    ".--", "--.."};
            Set<String> set = new TreeSet<>();

            for (String word : words) {
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    int index = word.charAt(i) - 'a';
                    res.append(morseCode[index]);
                }
                set.add(res.toString());
            }
            return set.size();
        }
    }
}
