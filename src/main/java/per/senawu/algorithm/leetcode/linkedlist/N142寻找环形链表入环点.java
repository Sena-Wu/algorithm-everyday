package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/4/19
 */
/**
 * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 * 
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 */

/**
 * 快慢指针 先判断链表是否存在环 快慢指针相遇时存在环并寻找入环点
 * 快慢指针相遇时快慢指针走的节点数: (走到链表头结点算是第一步)
 *      slow = x + y        x : 入环前所走节点数    y : 入环后所走几点数
 *      quick = x + y + nc  n : 任一一个大于1的正数 c : 环的总结点数
 *      2 * slow = quick  ==> x + y = nc  ==>
 *      x = nc -y == > 从相遇点开始走 nc -y 步可到达入环点的上一个节点(在环中）
 *                     从链表头部走 x 步可走到入环前的上一个节点(在单链中)
 *      ==> 一个指针p从相遇点开始走 一个指针q在入链点开始走 他们最终在入环点相遇
 *      注：第一步：p = 相遇点.next  ;   q = head;
 *
 */
public class N142寻找环形链表入环点 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode quick = head.next;
        ListNode slow = head;
        while(quick != null && quick.next != null){
            // 存在环
            if(quick == slow){
                // 一个指针quick在相遇节点 一个指针slow从链表头部开始(未指向头结点) 相遇在入环点
                // slow走到链表头结点需要一步 同时quick也前进一步
                slow = head;
                quick = quick.next;
                while(quick != slow){
                    quick = quick.next;
                    slow = slow.next;
                }
                return slow;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        return null;
    }
}
