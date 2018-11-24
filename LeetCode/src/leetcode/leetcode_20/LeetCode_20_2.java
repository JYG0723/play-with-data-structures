package leetcode.leetcode_20;

import java.util.Stack;

/**
 * @author Ji YongGuang.
 * @date 12:40 2018/11/21.
 * @description 有效的括号
 * 先判断特殊情况，由于3种括号，每种括号都必须被左右类型括号所匹配。
 * 所以每种类型的括号一定是偶数个。所以我们可以对3种类型每种括号进行计数，最后对3个总数对2进行取余。
 */
public class LeetCode_20_2 {

    /**
     * 输入: "()"
     * 输出: true
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     * <p>
     * 输入: "(]"
     * 输出: false
     * <p>
     * 输入: "([)]"
     * 输出: false
     * <p>
     * 输入: "{[]}"
     * 输出: true
     * <p>
     * 有效字符串需满足：
     * <p>
     * 1. 左括号必须用"相同类型"的右括号闭合。
     * 2. 左括号必须以"正确的顺序"闭合。
     */
    public boolean isValid_(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '(' || a == '[' || a == '{') {
                stack.push(a);
            } else {
                char target = '-';
                switch (a) {
                    case ')': target = '(';break;
                    case ']': target = '[';break;
                    case '}': target = '{';break;
                    default: target = '-';break;
                }

                if (stack.empty() || stack.pop() != target) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

}
