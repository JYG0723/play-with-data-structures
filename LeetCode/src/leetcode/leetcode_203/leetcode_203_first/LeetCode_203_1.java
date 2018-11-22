package leetcode.leetcode_203.leetcode_203_first;

/**
 * @author Ji YongGuang.
 * @date 23:34 2018/4/19.
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * 删除链表中的元素
 */
public class LeetCode_203_1 {

    class Solution {

        public ListNode removeElements(ListNode head, int val) {

            while (head != null && head.val == val) {
                head = head.next;
            }

            ListNode prev = head;
            while (prev.next != null) {
                if (prev.next.val == val) {
                    prev.next = prev.next.next;
                } else {
                    prev = prev.next;
                }
            }

            return head;
        }
    }
}
