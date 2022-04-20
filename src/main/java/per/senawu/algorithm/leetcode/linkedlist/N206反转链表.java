package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/4/20
 */

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */

/**
 * 头插法
 */
public class N206反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode work = head;
        ListNode tmp;
        while(work != null){
            tmp = work.next;
            work.next = result;
            result = work;
            work = tmp;
        }
        return result;
    }
}
