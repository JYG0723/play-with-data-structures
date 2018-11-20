package leetcode.leetcode_682;

import java.util.Stack;

/**
 * @author Ji YongGuang.
 * @date 17:18 2018/4/18.
 * 棒球比赛
 */
public class LeetCode_682 {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String value : ops) {
            if (value.equals("D")) {
                int frontValue = ((int) stack.peek()) << 1;
                stack.push(frontValue);
            } else if (value.equals("C")) {
                stack.pop();
            } else if (value.equals("+")) {
                int a = stack.pop();
                int b = stack.peek();
                int nowCount = a + b;
                stack.push(a);
                stack.push(nowCount);
            } else {
                int element = Integer.valueOf(value);
                stack.push(element);
            }
        }

        for (int score : stack) {
            sum += score;
        }
        return sum;
    }
}
