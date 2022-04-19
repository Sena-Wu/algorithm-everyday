package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/4/19
 */

/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */

/**
 * 快慢指针 quick走两步，slow走一步; quick 走到终点 slow刚好在中间节点
 */
public class N876链表的中间节点 {
    public ListNode middleNode(ListNode head) {
        if (head.next == null){
            return head;
        }
        ListNode quick = head.next;
        ListNode slow = head;
        // slow 走了n 步 quick 走了 2n步
        while (quick != null){
            // 2n + 1 步为空 总结点个数2n
            if (quick.next == null){
                return slow.next;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        // 第2n 个节点不存在 总结点数为2n -1
        return slow;
    }
}
