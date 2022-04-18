package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/4/18
 */

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
/**
 * 双指针；quick指针比slow指针先走N个节点
 */
public class N19删除链表倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode quick = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++){
            quick = quick.next;
        }
        // quick当前在第n+1个节点
        if(quick == null){
            // 整个链表的长度为n ,直接删除头结点
            return head.next;
        }
        // slow在倒数第n+1个
        while(quick.next != null){
            quick = quick.next;
            slow = slow.next;
        }
        // slow在倒数第n+1个 quick在倒数第一个
        slow.next = slow.next.next;
        return head;

    }
}
