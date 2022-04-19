package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/4/19
 */

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构
 *
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */

/**
 * 长链表 A 短链表 B
 * 两个指针分别从两条链表的头结点出发，步伐一致
 * 先到尾结点的链表长度更短；另一个指针q到其链表A尾结点的距离是 两条链表的长度差值
 * 此时让先到达尾结点的指针p指向更长链表A的头结点
 * 与另外一个指针q共同前进，当q到达尾结点时， p节点指向的链表的长度与链表B的长度相等
 * q指向链表B
 * p q 同步伐前进 相遇点为交点
 */
public class N160两条链表相交点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB){
            return headA;
        }
        ListNode p = headA;
        ListNode q = headB;
        while(p.next != null & q.next != null){
            p = p.next;
            q = q.next;
        }
        if (p.next == null){
            p = headB;
            while(q.next != null){
                q = q.next;
                p = p.next;
            }
            q = headA;
        }else{
            q = headA;
            while(p.next != null){
                q = q.next;
                p = p.next;
            }
            p = headB;
        }
        while(p != q){
            p = p.next;
            q = q.next;
        }
        return p;

    }
}
