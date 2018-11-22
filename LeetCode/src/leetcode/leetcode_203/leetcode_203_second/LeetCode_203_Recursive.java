package leetcode.leetcode_203.leetcode_203_second;

/**
 * @author Ji YongGuang.
 * @date 15:56 2018/11/22.
 * @description 移除链表元素 递归解法
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class LeetCode_203_Recursive {

    /**
     * 该函数的功能是删除 头结点为head的链表中所有val匹配的节点。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 删除head节点后 子链表的val节点。
        ListNode listNode = removeElements(head.next, val);
        // head子链表 处理完之后
        return head.val == val ? head.next : head;
    }
}
