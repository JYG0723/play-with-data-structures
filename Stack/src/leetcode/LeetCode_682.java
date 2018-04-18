package leetcode;

import java.util.Stack;

/**
 * @author Ji YongGuang.
 * @date 17:18 2018/4/18.
 */
public class LeetCode_682 {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            Object value = ops[i];
            if (value.equals("D")) {
                int frontValue = ((int) stack.peek()) << 1;
                sum += frontValue;
                stack.push(frontValue);
                continue;
            }
            if (value.equals("C")) {
                int a = stack.pop();
                sum -= a;
                continue;
            }
            if (value.equals("+")) {
                int a = stack.pop();
                int b = stack.peek();
                int nowCount = a + b;
                stack.push(a);
                stack.push(nowCount);
                sum += nowCount;
                continue;
            }
            int element = Integer.valueOf((String) value);
            stack.push(element);
            sum += element;
        }
        return sum;
    }
}
