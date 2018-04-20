package leetcode.leetcode_203;

/**
 * @author Ji YongGuang.
 * @date 7:53 2018/4/20.
 */
public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {
        // 判断极值
        if (head == null) {
            return null;
        }
        // 分解
        // 需要想到这是层层深入的解决办法。最先处理完的是最内层的节点，然后最内层的结果传递给外层使用
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
        /*ListNode prev = removeElements(head.next, val);
        if (head.val == val) {
            return prev;
        } else {
            head.next = prev;
            return head;
        }*/
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2};

        ListNode head = new ListNode(arr);

        ListNode newHead = new Solution3().removeElements(head, 2);

        System.out.println(newHead);

    }
}
