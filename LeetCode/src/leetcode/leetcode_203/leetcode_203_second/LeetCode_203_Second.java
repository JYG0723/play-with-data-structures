package leetcode.leetcode_203.leetcode_203_second;

/**
 * @author Ji YongGuang.
 * @date 11:50 2018/11/22.
 * @description 移除链表元素
 */
public class LeetCode_203_Second {

    /**
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     * 前驱节点来判断后续节点的val是否为6，然后控制其是否被删除
     */
    public static ListNode removeElements(ListNode head, int val) {

        ListNode remNode;
        // 排除头结点为6
        while (head != null && head.val == val) {
            remNode = head;
            head = head.next;
            remNode.next = null;
        }

        ListNode prevNode = head;

        if (head == null) {
            return null;
        }
        while (prevNode.next != null) {
            if (prevNode.next.val == val) {
                remNode = prevNode.next;
                prevNode.next = remNode.next;
                remNode.next = null;
                // 无法执行prevNode = prevNode.next;
                // 因为不清楚新接上来的Node的val是否为6，还需要经过下一轮的验证
            } else {
                prevNode = prevNode.next;
            }
        }

        return head;
    }
}
