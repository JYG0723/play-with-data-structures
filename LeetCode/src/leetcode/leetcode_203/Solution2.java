package leetcode.leetcode_203;

/**
 * @author Ji YongGuang.
 * @date 7:53 2018/4/20.
 */
public class Solution2 {

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

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,2};

        ListNode head = new ListNode(arr);

        ListNode newHead = new Solution2().removeElements(head, 2);

        System.out.println(newHead);

    }
}
