package leetcode.leetcode_203.leetcode_203_first;

/**
 * @author Ji YongGuang.
 * @date 7:53 2018/4/20.
 */
public class LeetCode_203_2 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return dummyNode.next;
    }
}
