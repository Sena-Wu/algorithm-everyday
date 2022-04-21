package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/4/20
 */

/**
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 */

/**
 * 头插法
 */
public class N92反转链表指定区间 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right){
            return head;
        }

        ListNode pre = null;
        ListNode work = head;
        for (int i = 0; i < left -1; i++){
            pre = work;
            work = work.next;
        }

        // work在第left个节点 l表示第left个节点 也是result的最后一个节点
        ListNode l;
        l = work;

        // 反转[left, right]链表
        ListNode result = null;
        for (int i = 0; i < right -left + 1; i++){
            ListNode tmp;
            tmp = work.next;
            work.next = result;
            result = work;
            work = tmp;
        }

        // 将result与前后部分拼接

        // work 在第right + 1个几点
        l.next = work;
        // pre 是第left-1个节点
        if (pre != null){
            pre.next = result;

        }

        head = pre == null ? result : head;
        return head;
    }
}
