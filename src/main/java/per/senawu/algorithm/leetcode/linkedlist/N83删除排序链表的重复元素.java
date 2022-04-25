package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/4/25
 */

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class N83删除排序链表的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while(quick != null){
            if (quick.val == slow.val){
                quick = quick.next;
            }else{
                slow.next = quick;
                quick = quick.next;
                slow = slow.next;
            }
        }
        // 处理最后一个节点
        slow.next = null;
        return head;

    }
}
