package leetcode;

import java.util.Stack;

/**
 * @author Ji YongGuang.
 * @date 16:11 2018/4/18.
 * LeetCode_20
 */
public class LeetCode_20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // 字符串截值字符
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {

                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                // 栈顶元素
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
