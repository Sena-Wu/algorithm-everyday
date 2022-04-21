package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/4/21
 */

/**
 * 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 */

/**
 * 1、反转前k个节点 链表长度不足K直接返回该链表
 * 2、递归的处理剩余链表
 * 将1中反转的链表与剩余处理后的链表拼接后返回
 */
public class N25K个一组反转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 1;
        ListNode work = head;
        while (work != null && count != k){
            count++;
            work = work.next;
        }
        // 存在第K个节点
        if (count == k && work != null){
            // 反转前k个节点
            ListNode next = work.next;
            work.next = null;
            ListNode newHead = reverse(head);
            // head 已经成为了反转后的尾结点; 拼接剩余链表的反转结果
            head.next = reverseKGroup(next, k);
            return newHead;
        }else{
            // 链表不足K个节点直接返回
            return head;
        }
    }
    ListNode reverse(ListNode head){
        ListNode result = null;
        ListNode tmp;
        while(head != null){
            tmp = head.next;
            head.next = result;
            result = head;
            head = tmp;
        }
        return result;
    }
}
